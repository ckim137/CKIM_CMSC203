
public abstract class Beverage {
	//private variables for beverage name, type of beverage, and size
	private String bevName;
	private Type type;
	private Size size;
	
	//prices for each size
	final double BASE_PRICE = 2.00;
	final double MEDIUM_PRICE = 1.00;
	final double LARGE_PRICE = 2.00;
	
	//constructor given beverage name, type, and size
	public Beverage(String bevName, Type type, Size size)
	{
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	//returns new price by adding size price to base price
	public double addSizePrice() 
	{ 
		switch(size) {
		case SMALL:
			return BASE_PRICE; //no need to add anything, small price is the same as base price
		case MEDIUM:
			return BASE_PRICE + MEDIUM_PRICE;
		case LARGE:
			return BASE_PRICE + LARGE_PRICE;
		default:
			return 0;			
		}
	}

	//checks whether this beverage is equal to another beverage by comparing each name, size, and type
	public boolean equals(Beverage anotherBev) 
	{ 
		if(anotherBev.bevName == bevName && anotherBev.size == size && anotherBev.type == type)
			return true;
		return false;
	}
	
	//returns base price
	public double getBasePrice() 
	{ 
		return BASE_PRICE;
	}
	
	//returns beverage name
	public String getBevName() 
	{ 
		return bevName;
	}
	
	//returns beverage size
	public Size getSize() 
	{ 
		return size;
	}
	
	//returns beverage type 
	public Type getType() 
	{ 
		return type;
	}
	
	//returns string in form of beverageName,size
	public String toString() 
	{ 
		return String.format("%s,%s", bevName, size);
	}
	
	//abstract method that calculates each final price
	abstract double calcPrice(); 
	
}
