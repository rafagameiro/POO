/**
 * 
 */

import java.util.Iterator;
import java.util.Scanner;

import DataBase.Product;
import DataBase.SuperMarket;
import DataBase.SuperMarketclass;
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
public class Main {
	
	//Commands
	static final String CREATE_OPTION = "CRIA";
	static final String CREATE_CART = "CARRINHO";
	static final String CREATE_PRODUCT = "ARTIGO";
	static final String ADD_PRODUCT = "DEPOSITA";
	static final String REMOVE_PRODUCT = "REMOVE";
	static final String LIST_PRODUCTS = "LISTA";
	static final String PAY_BILL = "PAGA";
	static final String LEAVE = "SAIR";
	
	//Success answers
	static final String CART_CREATED = "Carrinho criado com sucesso.";
	static final String PRODUCT_CREATED = "Artigo criado com sucesso.";
	static final String PRODUCT_ADDED = "Artigo adicionado com sucesso.";
	static final String PRODUCT_REMOVED = "Artigo removido com sucesso.";
	static final String COME_BACK = "Volte sempre.";
	
	//Error answers
	static final String EXISTENT_CART = "Carrinho existente!";
	static final String EXISTENT_PRODUCT = "Artigo existente!";
	static final String NO_CART = "Carrinho inexistente!";
	static final String NO_PRODUCT = "Artigo inexistente!";
	static final String EXCEEDED_CAPACITY = "Capacidade excedida!";
	static final String NO_PRODUCT_IN_CART = "Artigo inexistente no carrinho!";
	static final String EMPTY_CART = "Carrinho vazio!";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		SuperMarket sm = new SuperMarketclass();
		String option = " ";
		
		while(!option.equalsIgnoreCase(LEAVE)){
			option = in.next().toUpperCase();
			switch(option){
			case CREATE_OPTION:
				String option2 = in.next().toUpperCase();
				switch(option2){
				case CREATE_CART:createCart(in,sm);
					break;
				case CREATE_PRODUCT:createProduct(in,sm);
					break;
				}
				break;
			case ADD_PRODUCT:addProduct(in,sm);
				break;
			case REMOVE_PRODUCT:removeProduct(in,sm);
				break;
			case LIST_PRODUCTS:listProducts(in,sm);
				break;
			case PAY_BILL: payBill(in,sm);
				break;
			case LEAVE: System.out.println(COME_BACK);
				break;
			}
			System.out.println();
		}
		in.close();
	}

	private static void createCart(Scanner in, SuperMarket sm) {
		// TODO Auto-generated method stub
		String name = in.next().trim();
		int capacity = in.nextInt();in.nextLine();
		try{
			sm.addShoppingCart(name, capacity);
			System.out.println(CART_CREATED);
		}catch(CartAlreadyExistsException e){
			System.out.println(EXISTENT_CART);
		}
	}

	private static void createProduct(Scanner in, SuperMarket sm) {
		// TODO Auto-generated method stub
		String name = in.next().trim();
		int price = in.nextInt();
		int volume = in.nextInt();in.nextLine();
		try{
			sm.addProduct(name, price, volume);
			System.out.println(PRODUCT_CREATED);
		}catch(ProductAlreadyExistsException e){
			System.out.println(EXISTENT_PRODUCT);
		}
	}

	private static void addProduct(Scanner in, SuperMarket sm) {
		// TODO Auto-generated method stub
		String product = in.next().trim();
		String cart = in.next().trim();
		try{
			sm.addProductToCart(cart, product);
			System.out.println(PRODUCT_ADDED);
		}catch(NoCartException e){
			System.out.println(NO_CART);
		}catch(NoProductException e){
			System.out.println(NO_PRODUCT);
		}catch(ExceededCapacityException e){
			System.out.println(EXCEEDED_CAPACITY);
		}
	}

	private static void removeProduct(Scanner in, SuperMarket sm) {
		// TODO Auto-generated method stub
		String product = in.next().trim();
		String cart = in.next().trim();
		try{
			sm.removeProduct(cart, product);
			System.out.println(PRODUCT_REMOVED);
		}catch(NoCartException e){
			System.out.println(NO_CART);
		}catch(NoProductInCartException e){
			System.out.println(NO_PRODUCT_IN_CART);
		}
	}

	private static void listProducts(Scanner in, SuperMarket sm) {
		// TODO Auto-generated method stub
		String cart = in.nextLine().trim();
		try{
			Iterator<Product> it = sm.getCartProducts(cart);
			while(it.hasNext()){
				Product product = it.next();
				System.out.println(product.getName() + " " + product.getPrice());
			}
		}catch(NoProductInCartException e){
			System.out.println(EMPTY_CART);
		}catch(NoCartException e){
			System.out.println(NO_CART);
		}
	}

	private static void payBill(Scanner in, SuperMarket sm) {
		// TODO Auto-generated method stub
		String cart = in.nextLine().trim();
		try{
			int bill = sm.getBill(cart);
			System.out.println(bill);
		}catch(NoCartException e){
			System.out.println(NO_CART);
		}catch(EmptyCartException e){
			System.out.println(EMPTY_CART);
		}
	}

}
