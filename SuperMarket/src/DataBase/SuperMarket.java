/**
 * 
 */
package DataBase;

import java.util.Iterator;

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
public interface SuperMarket {
	
	void addShoppingCart(String name, int size) throws CartAlreadyExistsException;
	
	void addProduct(String name, int price, int volume) throws ProductAlreadyExistsException;
	
	void addProductToCart(String cart, String product) throws NoCartException, NoProductException, ExceededCapacityException;
	
	void removeProduct(String cart, String product) throws NoCartException, NoProductInCartException;
	
	int getBill(String cart) throws NoCartException, EmptyCartException;
	
	Iterator<Product> getCartProducts(String name) throws NoProductInCartException, NoCartException;

}
