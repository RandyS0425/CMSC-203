/**
 * @author Randy Barreda
 */
public class Customer {
	private String name;
	private int age;
	/**
	 *A parametrized constructor  for Customer
	 * @param name
	 * @param i
	 */
	public Customer(String name, int i) {
		this.age = i;
		this.name = name;
	}

	/**
	 *A Copy constructor  
	 * @param c1
	 */
	public Customer(Customer c1) {
		this.age = c1.age;
		this.name = c1.name;
	}

	
	/**
	 *String representation for Customer including the name and age 
	 *Return a representation for Customer including the name and age
	 */
	@Override
	public String toString() {
		return getName() + " " + getAge() ;
	}

	/**
	 * Setter method for the customer name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;		
	}

	/**
	 * Setter method for the customer age
	 * @param i
	 */
	public void setAge(int i) {
		this.age = i;
		
	}

	/**
	 * Getter method for the customer name
	 * @return the customer name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Getter method for the customer age
	 * @return the customer age
	 */
	public int getAge() {
		return this.age;
	}

}
