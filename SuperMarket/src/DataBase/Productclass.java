/**
 * 
 */
package DataBase;

/**
 * @author Rafael Gameiro
 *
 */
public class Productclass implements Product {
	
	private String name;
	private int price;
	private int volume;
	
	public Productclass(String name, int price, int volume){
		this.name = name;
		this.price = price;
		this.volume = volume;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public int getVolume() {
		// TODO Auto-generated method stub
		return volume;
	}

}
