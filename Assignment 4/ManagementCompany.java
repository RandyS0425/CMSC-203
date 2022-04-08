
/**
 * @author Randy Barreda
 *
 */


public class ManagementCompany {
	private final int MAX_PROPERTY=5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH=10;
	private final int MGMT_DEPTH=10;
	private Plot plot;
	private int index=0;
	
	
	/*
	 * No Arg constructor 
	 */
	public ManagementCompany(){
		this("","",0,0,0,1,1);
	/*	this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties =  new Property[MAX_PROPERTY];*/
		
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information. Mgmt Co plot is initialized to default Plot. "properties" array is initialized here as well.
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee){
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties =  new Property[MAX_PROPERTY];
	}
	
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. "properties" array is initialized here as well.
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x,y,width,depth);
		this.properties =  new Property[MAX_PROPERTY];
	}
	
	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. "properties" array is initialized here as well.
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany){
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}
	
	/**
	 * Return the MAX_PROPERTY constant that represent the size of the "properties" array.
	 * @return the MAX_PROPERTY constant that represent the size of the "properties" array
	 */
	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}
	
	/**
	 * Adds the property object to the "properties" array.
	 * @param property
	 * @return  either -1 if the array is full,
	 * -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {
		if(this.index >= this.MAX_PROPERTY) return -1;
		if(property == null) return -2;
		if(!this.getPlot().encompasses(property.getPlot())) return -3;
		if(!this.getPlot().encompasses(property.getPlot())) return -4;
		for( int i=0; i<properties.length; i++) {
			if(properties[i] != null) {
				if(properties[i].getPlot().overlaps(property.getPlot()) == true)  
					return -4; 
				if(properties[i].getPlot().encompasses(property.getPlot()) == true) 
					return -3;
			}
		}
				properties[index]=property;	
				this.index++;
				return this.index-1;
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return either -1 if the array is full,
	 * -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner) {
		return this.addProperty( new Property(name,city,rent,owner));
	}
	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return either -1 if the array is full,
	 * -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
		return this.addProperty(new Property(name,city,rent,owner,x,y,width,depth));
	}
	/**
	 * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
	 * @return total rent
	 */
	public double totalRent() {
		double total_rent=0;
		if(this.properties.length==0) return total_rent;
		for(int i =0; i<this.properties.length; i++) {
			if(properties[i]!=null)
				total_rent+=this.properties[i].getRentAmount();
		}
		return total_rent;
	}
	
	/**
	 * This method finds the property with the maximum rent amount and returns its toString result. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return the maximum rent amount
	 */
	public double maxRentProp() {
		double max_rent =0.0;
		if(this.properties.length==0) return max_rent;
		max_rent=this.properties[0].getRentAmount();
		for(int i =0; i<this.properties.length; i++) {
			if(this.properties[i] != null) {				
				if(max_rent < this.properties[i].getRentAmount())
					max_rent=this.properties[i].getRentAmount();
			}
		}
		return max_rent;
	}
	
	// I changed to make it public because we cannot access that in the propertyMgmDriverNoGUI
	/**
	 * This method finds the index of the property with the maximum rent amount.
	 *  NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return
	 */
	public  int maxRentPropertyIndex() {
		int max_index=0;
		if(this.properties.length==0) return max_index;
		for(int i =0; i<this.properties.length; i++) {
			if(this.properties[i] != null){
			if(this.maxRentProp() == this.properties[i].getRentAmount() ) 
				max_index= i;
			}
		}
		return max_index;
	}
	
	/**
	 * 
	 * Displays the information of the property at index i
	 * @param i
	 * @return
	 */
	// I changed to make it public because we cannot access that in the propertyMgmDriverNoGUI
	public String displayPropertyAtIndex(int i) {
		return this.properties[i].toString();
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @return a plot
	 */
	public Plot getPlot() {
		return plot;
	}

	

	/**
	 *Displays the information of all the properties in the "properties" array.
	 */
	public String  toString() {
		String result="";
		result += "List of the properties for "+this.getName()+", taxID: "+this.taxID+" \n";
		result+="\n----------------------------------------------------------------\n";
		for(int i =0; i<this.properties.length; i++) {
			result+= this.displayPropertyAtIndex(i);
		}
		result+="\n----------------------------------------------------------------\n";
		result+="\ntotal management Fee: "+ (totalRent() * mgmFeePer / 100)+"\n";
		return result;
	}
}
