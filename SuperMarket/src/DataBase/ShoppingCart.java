/**
 * 
 */
package DataBase;

import java.util.Iterator;

/**
 * @author Rafael Gameiro
 *
 */
public interface ShoppingCart {
	
	void addProduct(String name, int price, int volume);
	
	String getName();
	
	int getCapacity();
	
	boolean hasProduct(String name);
	
	void removeProduct(String name);
	
	void clear();
	
	boolean isEmpty();
	
	Iterator<Product> getProducts();

}
