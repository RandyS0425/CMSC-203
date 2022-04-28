

/**
 * @author Randy Barreda
 *
 */


public class Alcohol extends Beverage {
	private boolean isOfferedWeekend;
	
	/**
	 * Constructor for Alcohol 
	 * @param name
	 * @param size
	 * @param b
	 */
	public Alcohol(String name, SIZE size, boolean b) {
		super(name,size);
		this.isOfferedWeekend = b;
		setType(TYPE.ALCOHOL);
	}
	
	
	/**
	 *	An Overridden calcPrice method.The additional cost for drinks offered in the weekend is 60 cents. 
	 *	calculates and returns the alcohol price
	 *@return  the alcohol price
	 */
	@Override
	public double calcPrice() {
		double value = this.getBasePrice();
		if(isOfferedWeekend())
			value+=0.6;
		if(getSize()==SIZE.MEDIUM)
			value+=1;
		if(getSize()==SIZE.LARGE)
			value+=2;
		
	 return value;
	}
	
	/**
	 *String representation of a alcohol drink including the name, size, 
	 *whether or not beverage is offered in the weekend and the price
	 *@return a representation of a alcohol drink including the name, size,whether or not beverage is offered in the weekend and the price
	 */
	@Override
	public String toString() {
		return getName() + " "+getSize()+" " +isOfferedWeekend() +" "+calcPrice(); 	
	}
	/*
	 *checks equality based on the Beverage class equals method and additional instance variables for this class 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alcohol other = (Alcohol) obj;
		if (isOfferedWeekend != other.isOfferedWeekend)
			return false;
		return true;
	}
	
	/**
	 * Setter method for isOfferedWeekend
	 * @param isOfferedWeekend
	 */
	public void setOfferedWeekend(boolean isOfferedWeekend) {
		this.isOfferedWeekend = isOfferedWeekend;
	}
	/**
	 * Getter method for isOfferedWeekend
	 * @return the value true or false 
	 */
	public boolean isOfferedWeekend() {
		return isOfferedWeekend;
	}


	
}
