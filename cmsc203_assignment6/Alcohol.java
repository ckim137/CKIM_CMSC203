
public class Alcohol extends Beverage {
	//variable to check whether it's weekend or not
	private boolean isWeekend; 
	
	//constant that holds extra price for weekends
	final private double WEEKEND_PRICE = .60;
	
	//constructs alcohol object given beverage methods and whether it is weekend or not
	public Alcohol(String bevName, Size size, boolean isWeekend) 
	{ 
		super(bevName,Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public double calcPrice() 
	{ //Calculates the price of the alcohol
		double total = addSizePrice();
		if(isWeekend == true)
			total += WEEKEND_PRICE;
		return total;
	}
	
	//checks whether alcohol equals another beverage
	public boolean equals(Alcohol anotherBev) 
	{ 
		if(super.equals(anotherBev) && anotherBev.isWeekend == isWeekend)
			return true;
		return false;
	}
	
	//returns string that represents alcohol object, formatted as beverage name,size,whether it's weekend,final price
	public String toString() 
	{ 
		return String.format("%s,%s,%s,$%.2f", getBevName(), getSize(), isWeekend, calcPrice());
	}
}