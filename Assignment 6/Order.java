/**
 * @author Randy Barreda
 *
 */
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable {

	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages ; //list of beverages within  order
	
	
	
	
	/**
	 * Parametrized constructor for Order class
	 * @param i
	 * @param day
	 * @param customer
	 */
	public Order(int i, DAY day, Customer customer) {
		this.orderTime = i;
		this.orderNumber = random();
		this.orderDay = day;
		this.customer = new Customer(customer);
		this.beverages = new ArrayList<Beverage>();
	}
	
	
	/**
	 *random method to generate a random number within the range of 10000 and 90000
	 * @return a random number within the range of 10000 and 90000
	 */
	public int random() {
		Random rand = new Random();
		return rand.nextInt(90000)+10000;
	}
	
	 
	
	/**
	 *String representation of an order including order number, time, day, customer name , customer age and the list of beverages
	 *@return order number, time, day, customer name , customer age and the list of beverages
	 */
	@Override
	public String toString() {
		return this.getOrderNo() +" "+ getOrderTime()+ " " + getOrderDay()+ " " + getCustomer() + " " + beverages+" "+calcOrderTotal();
	}
	
	/** 
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	@Override
	public boolean isWeekend() {
		if(this.orderDay == DAY.SATURDAY || this.orderDay == DAY.SUNDAY)
			return true;
		return false;
	}
	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
		if(this.beverages.size()==0)
			return null;
		return beverages.get(itemNo);
	}
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		this.beverages.add(new Coffee(bevName,size,extraShot, extraSyrup));
	}

	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		this.beverages.add(new Alcohol(bevName,size, isWeekend()));

	}
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		this.beverages.add(new Smoothie(bevName, size, numOfFruits, addPRotien));

	}
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	@Override
	public double calcOrderTotal() {
		double amount=0;
		for(int i=0; i<beverages.size(); i++) {
			amount +=beverages.get(i).calcPrice();
		}
		return amount;
	}
	/**
	 * returns the number of beverages of same type in an order
	 * @param  the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	@Override
	public int findNumOfBeveType(TYPE type) {
		
		int  nbres=0;
		for(int i=0; i<beverages.size(); i++) {
			if(beverages.get(i).getType() == type)
				nbres++;
		}
		return nbres;
	}

	/**
	 * @param Object
	 *compareTo method to compare this order with another order based on the order number. 
	 *Returns 0 if this order number is same as another order's order number, 1 if it is greater than another order's order number, -1 if it smaller than another order's order number.
	 *@return 0 if this order number is same as another order's order number, 1 if it is greater than another order's order number, -1 if it smaller than another order's order number.
	 */
	@Override
	public int compareTo(Object arg0) {
		Order other = (Order) arg0;
		if (this.orderNumber > other.orderNumber)
			return 1;
		if(this.orderNumber < other.orderNumber)
			return -1;
		return 0;
	}
	
	/**
	 * Getter method for orderNumber
	 * @return the order number 
	 */
	public int getOrderNo() {
		return orderNumber;
	}
	/**
	 * Setter method for orderNumber
	 * @param orderNumber
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/**
	 * Getter method for orderTime
	 * @return the order time 
	 */
	public int getOrderTime() {
		return orderTime;
	}
	
	/**
	 * Setter method for orderTime
	 * @param orderTime
	 */
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	
	/**
	 * Getter method for orderDay
	 * @return the order day 
	 */
	public DAY getOrderDay() {
		return orderDay;
	}
	/**
	 * Setter method for orderDay
	 * @param orderDay
	 */
	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}
	
	/**
	 * Getter method for the customer 
	 * @return a Deep copy of the customer.
	 */
	public Customer getCustomer() {
		//Customer custom = new Customer(this.customer.getName(), this.customer.getAge());
		return new Customer(this.customer);
	}
	/**
	 * Setter method for customer
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	/**
	 * Getter method for beverages
	 * @return a list of beverages
	 */
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	
	/**
	 * Setter method for beverages
	 * @param beverages
	 */
	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	/**
	 * @return the total number of items in the order 
	 */
	public int getTotalItems() {
		if(beverages.size()==0)
			return 0;
		return beverages.size();
	}
	
	

}
