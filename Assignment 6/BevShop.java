/**
 * @author Randy Barreda
 *
 */
import java.util.ArrayList;


public class BevShop implements BevShopInterface   {
	
	
	private int numAlcoholOdered; 
	public ArrayList<Order> orders = new ArrayList<Order>(); 
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean validTime(int time) {
		if(time>= MIN_TIME && time <=MAX_TIME)
			return true; 
		return false;
	}
	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	@Override
	public boolean eligibleForMore() {
			if(this.numAlcoholOdered==MAX_ORDER_FOR_ALCOHOL )
				return false;
		return true;
	}
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	@Override
	public boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return orders + " "+totalMonthlySale();
	}
	
	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		this.numAlcoholOdered = 0;
		this.orders.add(new Order(time, day, new Customer(customerName,customerAge)));
	}
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
	if(numAlcoholOdered<=getMaxOrderForAlcohol()) {
		getCurrentOrder().addNewBeverage(bevName, size);
		this.numAlcoholOdered++;
		}
	}
	/**
	 * process the Smoothie order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	@Override
	public int findOrder(int orderNo) {
		
		for(int i=0; i<this.orders.size(); i++) {
			if(this.orders.get(i).getOrderNo() == orderNo) {
				return i; 
			}
		}
		
		return -1;
	}
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		for(int i=0; i<this.orders.size(); i++) {
			if(this.orders.get(i).getOrderNo() == orderNo) {
				return this.orders.get(i).calcOrderTotal();
			}
		}
		return 0;
	}
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	@Override
	public double totalMonthlySale() {
		double total=0;
		for(int i=0; i<this.orders.size(); i++) {
			total+=this.orders.get(i).calcOrderTotal();
		}
		return total;
	}
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	@Override
	public void sortOrders() {
		//Collections.sort(this.orders);
		 for (int i = 0; i < this.orders.size(); i++) {
	          for (int j = this.orders.size() - 1; j > i; j--) {
	              if (this.orders.get(i).compareTo(this.orders.get(j)) == 1) {
	                 // swap the value 
	            	  Order tmp = this.orders.get(i);
	                  this.orders.set(i,this.orders.get(j)) ;
	                  this.orders.set(j,tmp);
	              }
	          }
	      }
		
	}
	/**
	 * returns Order in the list of orders at the index
	 * @return Order in the list of orders at the index 
	 */
	@Override
	public Order getOrderAtIndex(int index) {
		return this.orders.get(index);
	}
	/**
	 * returns the current order 
	 * @return the current order 
	 */
	public Order getCurrentOrder() {
		
		return this.orders.get(this.orders.size()-1);
	}
	/**
	 * returns maximum order for the beverage alcohol  
	 * @return maximum order for the  alcohol 
	 */
	public int getMaxOrderForAlcohol() {
		
		return MAX_ORDER_FOR_ALCOHOL;
	}
	/**
	 * returns minimum  order for the beverage alcohol  
	 * @return minimum order for the  alcohol 
	 */
	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
	}
	/**
	 * returns the numbers of alcohol ordered   
	 * @return the numbers of alcohol ordered 
	 */
	public int getNumOfAlcoholDrink() {
		return numAlcoholOdered;
	}
	/**
	 * returns true is the numbers of fruits have reached the threshold   
	 * @return true or false based on the test whether or not the number of fruits have reached the threshold  
	 */
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits > MAX_FRUIT)
			return true;
		return false;
	}
	/**
	 * returns the numbers total of monthly orders  
	 * @return the numbers total of monthly orders 
	 */
	public int totalNumOfMonthlyOrders() {
		return this.orders.size();
	}


	

}
