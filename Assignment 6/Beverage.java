
/**
 * @author Randy Barreda
 
 *	abstract class  Beverage 
 */
public abstract class Beverage {
	
	private String name;
	private SIZE size;
	private TYPE type;
	private final double PRICE=2;
	
	
	/**
	 * Constructor for the class Beverage
	 * @param name
	 * @param size
	 */
	public Beverage(String name, SIZE size) {
		this.name = name;
		this.size = size;
	}
	
	/**
	 *String representation for Beverage including the name and size
	 *@return a representation for Beverage including the name and size
	 */
	@Override
	public String toString() {
		return "name is : "+getName()+ " size : "+getSize() ;
	}
	
	
	/**
	 * checks equality based on name, type, size of the beverage
	 *@return true or false after checking the equality based on name, type, size of the beverage
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beverage other = (Beverage) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	/**
	 * abstract method  calcPrice that calculates and returns the beverage price
	 */
	public abstract double calcPrice(); 
	
	/**
	 * getter method for name
	 * @return the beverage name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setter method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getter method for size
	 * @return the beverage size
	 */
	public SIZE getSize() {
		return size;
	}
	/**
	 * setter method for size
	 * @param size
	 */
	public void setSize(SIZE size) {
		this.size = size;
	}
	
	
	/**
	 * getter method for type
	 * @return the beverage type 
	 */
	public TYPE getType() {
		return type;
	}
	
	
	/**
	 * setter method for type
	 * @param type
	 */
	public void setType(TYPE type) {
		this.type = type;
	}
	
	/**
	 * getter method for price
	 * @return the beverage price
	 */
	public double getBasePrice() {
		return PRICE;
	}
	/**
	 * getter method for name
	 * @return the beverage name
	 */
	public String getBevName() {
		return name;
	}
}
