
/**
 * @author Randy Barreda
 *
 */
public class Coffee extends Beverage {
	

	private boolean extra_coffe, extra_syrup;
	
	/**
	 * Constructor for Coffee class
	 * @param name
	 * @param size
	 * @param b
	 * @param c
	 */
	public Coffee(String name, SIZE size,boolean b, boolean c) {
		super(name, size);
		this.extra_coffe = b;
		this.extra_syrup = c;
		setType(TYPE.COFFEE);
	}

	/**
	 *String representation of Coffee beverage, including the name , size ,
	 *  whether it contains extra shot, extra syrup and the price of the coffee
	 *  @return String representation of Coffee beverage, including the name , size ,whether it contains extra shot, extra syrup and the price of the coffee
	 */
	@Override
	public String toString() {
		return getName() + " "+calcPrice()+" " +getSize()+" "+isExtra_coffe()+" "+isExtra_syrup() ; 
	}

	/**
	 *checks equality based on the Beverage class equals method and additional instance variables for this class
	 *@return true or false based on the checking test
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coffee other = (Coffee) obj;
		if (extra_coffe != other.extra_coffe)
			return false;
		if (extra_syrup != other.extra_syrup)
			return false;
		return true;
	}
	/**
	 *	An Overridden calcPrice method.if it contains extra shot of coffee (additional cost of 50 cents) and extra syrup (additional cost of 50 cents).   
	 *	calculates and returns the coffee price
	 */
	@Override
	public double calcPrice() {
		double value = this.getBasePrice();
		if(isExtra_coffe())
			value+=0.5;
		if(isExtra_syrup())
			value+=0.5;
		if(getSize()==SIZE.MEDIUM)
			value+=1;
		if(getSize()==SIZE.LARGE)
			value+=2;
		
	 return value;
	}
	

	/**
	 * Getter method for extra_coffe
	 * @return the value of extra_coffe
	 */
	public boolean isExtra_coffe() {
		return extra_coffe;
	}

	/**
	 * Setter method for extra_coffe
	 * @param extra_coffe
	 */
	public void setExtra_coffe(boolean extra_coffe) {
		this.extra_coffe = extra_coffe;
	}
	/**
	 * Getter method for extra_syrup
	 * @return the value of extra_syrup
	 */

	public boolean isExtra_syrup() {
		return extra_syrup;
	}

	/**
	 * Setter method for extra_syrup
	 * @param extra_syrup
	 */
	public void setExtra_syrup(boolean extra_syrup) {
		this.extra_syrup = extra_syrup;
	}


	/**
	 * Getter method for extra_syrup
	 * @return the value of extra_syrup
	 */
	public boolean getExtraSyrup() {
		return isExtra_syrup();
	}

	/**
	 * Getter method for extra_coffe
	 * @return the value of extra_coffe
	 */

	public boolean getExtraShot() {

		return isExtra_coffe();
	}
	
	

}
