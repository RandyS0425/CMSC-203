
/**
 * @author Frank Choukouali
 *
 */
public class Plot {
	private int x; //The x-value of the upper-left corner of the Plot
	private int y;//The y-value of the upper-left corner of the Plot
	private int width;//The horizontal extent of the Plot
	private int depth;//The vertical extent of the Plot
	
	/**
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	public Plot(){
		this(0,0,1,1);
		/*this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;*/
		
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p
	 */
	public Plot ( Plot p) {
		this.x=p.x;
		this.y=p.y;
		this.width=p.width;
		this.depth=p.depth;
	}
	/**
	 * Parameterized Constructor
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}


	
	/**
	 * determines if this plot overlaps the parameter,returns true if the two plots overlap, false otherwise
	 * @param p
	 * @return a boolean value
	 */
	public boolean overlaps(Plot p) {
		boolean case_1 = this.x + this.width > p.x ;
		boolean case_2 = p.x + p.width > this.x ;
		boolean case_3 = this.y + this.depth > p.y;
		boolean case_4 = p.y + p.depth > this.y ;
		return  case_1 && case_2 && case_3 && case_4;
	}
	/**
	 * takes a Plot instance and determines if the current plot contains it.
		Note that the determination should be inclusive, in other words, 
		if an edge lies on the edge of the current plot, this is acceptable.
	 * @param p
	 * @return a boolean value
	 */
	public boolean encompasses(Plot p ) {
		boolean case_1 = this.x<=p.x  ;
		boolean case_2 = this.y<=p.y;
		boolean case_3 = this.x+this.width>=p.x+p.width;
		boolean case_4 = this.y+this.depth>= p.y+p.depth;
		return  case_1 && case_2 && case_3 && case_4;
	}

	/**
	 * Return the x value
	 * @return the x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x value
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Return the y value
	 * @return the y value
	 */
	public int getY() {
		return y;
	}

	/**
	 *  Sets the y value
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Return the width value
	 * @return the width value
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width value
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Return the depth value
	 * @return the depth value
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *  Sets the depth value
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 *Prints out the name, city, owner and rent amount for a property
	 * Prints the X,Y of the upper left corner, the width and the depth.
          Example:
               Upper left: (1,1); Width: 3 Depth: 3
	 */
	@Override
	public String toString() {
		return "Upper left: ("+x+","+y+"); Width: "+ width + " Depth: " + depth ;
	}

	
}
