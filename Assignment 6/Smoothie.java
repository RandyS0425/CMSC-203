/**
 * @author Randy Barreda
 *
 */
public class Smoothie extends Beverage{
	
	private int numberFruits;
	private boolean proteinPowder;

	/**
	 * Parametrized constructor for Customer class 
	 * @param name
	 * @param size
	 * @param i
	 * @param b
	 */
	public Smoothie(String name, SIZE size, int i, boolean b) {
		super(name, size);
		this.numberFruits = i;
		this.proteinPowder = b;
		setType(TYPE.SMOOTHIE);
	}

	/**
	 *  An Overridden equals method: checks equality based on the Beverage class equals method and additional instance variables for this class.
	 *	The cost of adding protein is $1.50 and each additional fruit costs 50 cents.
	 *@return  the Smoothie price
	 */
	@Override
	public double calcPrice() {
		double value = this.getBasePrice()+getNumOfFruits()*0.5;
		if(isProteinPowder())
			value+=1.5;
		if(getSize()==SIZE.MEDIUM)
			value+=1;
		if(getSize()==SIZE.LARGE)
			value+=2;
		
	 return value;
	}
	
	
	
	/**
	 *String representation of a Smoothie drink including the name , size, whether or not protein is added , number of fruits and the price
	 *@return  a representation of a Smoothie drink including the name , size, whether or not protein is added , number of fruits and the price
	 */
	@Override
	public String toString() {
		return getBevName() + " " +getSize()+" "+isProteinPowder()+" "+calcPrice()+" "+getNumOfFruits() ;
	}

	/**
	 * @param Object
	 *An Overridden equals method: checks equality based on the Beverage class equals method and additional instance variables for this class.
	 *@return return true or false based on the check
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Smoothie other = (Smoothie) obj;
		if (numberFruits != other.numberFruits)
			return false;
		if (proteinPowder != other.proteinPowder)
			return false;
		return true;
	}

	
	
	
	/**
	 * Getter method for numberFruits
	 * @return the number of fruits
	 */ 
	public int getNumOfFruits() {
		
		return this.numberFruits;
	}

	/**
	 * Setter method for numberFruits
	 * @param numberFruits
	 */
	public void setNumberFruits(int numberFruits) {
		this.numberFruits = numberFruits;
	}
	/**
	 * Getter method for proteinPowder
	 * @return the boolean value of proteinPowder
	 */
	public boolean isProteinPowder() {
		return proteinPowder;
	}
	/**
	 * Setter method for proteinPowder
	 * @param proteinPowder
	 */
	public void setProteinPowder(boolean proteinPowder) {
		this.proteinPowder = proteinPowder;
	}
	/**
	 * Getter method for proteinPowder
	 * @return the boolean value of proteinPowder
	 */
	public boolean getAddProtien() {
		return isProteinPowder();
	}

	

}
