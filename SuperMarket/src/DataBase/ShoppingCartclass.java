/**
 * 
 */
package DataBase;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Rafael Gameiro
 *
 */
public class ShoppingCartclass implements ShoppingCart {
	
	private String name;
	private int capacity;
	private ArrayList<Product> products;
	
	public ShoppingCartclass(String name, int size){
		products = new ArrayList<Product>();
		this.name = name;
		this.capacity = size;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}
	
	@Override
	public void addProduct(String name, int price, int volume) {
		// TODO Auto-generated method stub
		products.add(new Productclass(name,price,volume));
		capacity -= volume;
	}

	@Override
	public boolean hasProduct(String name) {
		// TODO Auto-generated method stub
		boolean has = false;
		for(int i = 0;i < products.size();i++){
			Product product = products.get(i);
			if(product.getName().equalsIgnoreCase(name))
				has = true;
		}
		return has;
	}

	@Override
	public void removeProduct(String name) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		for(int i = 0;i < products.size();i++){
			Product product = products.get(i);
			if(product.getName().equalsIgnoreCase(name) && !deleted){
				products.remove(i);
				deleted = true;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return products.isEmpty();
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		products.clear();
	}

	@Override
	public Iterator<Product> getProducts() {
		// TODO Auto-generated method stub
		return products.iterator();
	}

}
