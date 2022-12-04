
public class Coffee extends Beverage {
	//private variables for adding extra shot/syrup
	private boolean extraShot;
	private boolean extraSyrup;
	
	final private double EXTRA_PRICE = .50;
	
	//constructor using beverage name, size, and whether to add extra shot/syrup
	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	//returns whether beverage has extra shot added
	public boolean getExtraShot() 
	{ 
		return extraShot;
	}
	
	//returns whether beverage has extra syrup added
	public boolean getExtraSyrup() 
	{ 
		return extraSyrup;
	}
	
	//checks whether this coffee is equal to another coffee
	public boolean equals(Coffee anotherBev) 
	{ 
		if(super.equals(anotherBev) && anotherBev.extraShot == extraShot && anotherBev.extraSyrup == extraSyrup)
			return true;
		return false;
	}
	
	//returns a string in this format: name,size,whether it contains extra shot,whether it contains extra syrup,final price
	public String toString() 
	{ 
	
		return String.format("%s,%s,%s,$%.2f", super.toString(), extraShot, extraSyrup, calcPrice());
	}
	
	public double calcPrice() {
		double total = addSizePrice();
		
		//check whether to add extra toppings, if so, add extra prices to total
		if(extraShot == true)
			total += EXTRA_PRICE;
		if(extraSyrup == true)
			total += EXTRA_PRICE;
		return total;
	}
	
}
