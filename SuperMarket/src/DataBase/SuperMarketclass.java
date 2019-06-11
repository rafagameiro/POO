/**
 * 
 */
package DataBase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Exceptions.CartAlreadyExistsException;
import Exceptions.EmptyCartException;
import Exceptions.ExceededCapacityException;
import Exceptions.NoCartException;
import Exceptions.NoProductException;
import Exceptions.NoProductInCartException;
import Exceptions.ProductAlreadyExistsException;

/**
 * @author Rafael Gameiro
 *
 */
public class SuperMarketclass implements SuperMarket {
	
	 private Map<String,ShoppingCart> carts;
	 private Map<String,Product> products;
	 
	 
	 public SuperMarketclass(){
		 carts = new HashMap<String,ShoppingCart>();
		 products = new HashMap<String,Product>();
	 }


	@Override
	public void addShoppingCart(String name, int size) throws CartAlreadyExistsException{
		// TODO Auto-generated method stub
		if(carts.containsKey(name))
			throw new CartAlreadyExistsException();
		else
			carts.put(name, new ShoppingCartclass(name,size));
	}


	@Override
	public void addProduct(String name, int price, int volume) throws ProductAlreadyExistsException{
		// TODO Auto-generated method stub
		if(products.containsKey(name))
			throw new ProductAlreadyExistsException();
		else
			products.put(name, new Productclass(name,price,volume));
			
	}


	@Override
	public void addProductToCart(String cart, String product) throws NoCartException, NoProductException, ExceededCapacityException {
		// TODO Auto-generated method stub
		if(!carts.containsKey(cart))
			throw new NoCartException();
		else if(!products.containsKey(product))
			throw new NoProductException();
		else{
			ShoppingCart cartPre = carts.get(cart);
			Product productPre = products.get(product);
			if(cartPre.getCapacity()<productPre.getVolume())
				throw new ExceededCapacityException();
			else
			cartPre.addProduct(product, productPre.getPrice(), productPre.getVolume());
		}
	}


	@Override
	public void removeProduct(String cart, String product) throws NoCartException, NoProductInCartException {
		// TODO Auto-generated method stub
		if(!carts.containsKey(cart))
			throw new NoCartException();
		else{
			ShoppingCart cartPre = carts.get(cart);
			
			if(!cartPre.hasProduct(product))
				throw new NoProductInCartException();
			else
				cartPre.removeProduct(product);
		}
	}


	@Override
	public int getBill(String cart) throws NoCartException, EmptyCartException {
		// TODO Auto-generated method stub
		if(!carts.containsKey(cart))
			throw new NoCartException();
		else{
			ShoppingCart cartPre = carts.get(cart);
			if(cartPre.isEmpty())
				throw new EmptyCartException();
			else{
				Iterator<Product> it = cartPre.getProducts();
				int total = 0;
				while(it.hasNext()){
					Product product= it.next();
					total += product.getPrice();
				}
				cartPre.clear();
				return total;
			}
			
		}
	}


	@Override
	public Iterator<Product> getCartProducts(String name) throws NoProductInCartException, NoCartException {
		// TODO Auto-generated method stub
		if(!carts.containsKey(name))
			throw new NoCartException();
		else{
			ShoppingCart cartPre = carts.get(name);
			if(cartPre.isEmpty())
				throw new NoProductInCartException();
			else
				return cartPre.getProducts();
		}
	}
	 
	 

}
