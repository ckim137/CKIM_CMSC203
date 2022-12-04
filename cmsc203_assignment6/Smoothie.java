
public class Smoothie extends Beverage {
	//private variables for number of fruits added and protein
	private int numOfFruits;
	private boolean addProtein;
	
	//constants for prices of each fruit and protein
	final private double FRUITS_PRICE = .50;
	final private double PROTEIN_PRICE = 1.50;
	
	//constructs smoothie object given beverage fields, # of fruits, and whether to add protein
	Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	//returns # of fruits added
	public int getNumOfFruits() { 
		return numOfFruits;
	}
	
	//returns whether or not to add protein
	public boolean getAddProtein() {
		return addProtein;
	}
	
	//checks whether this smoothie equals another beverage
	public boolean equals(Smoothie anotherBev) {
		if(super.equals(anotherBev) && anotherBev.addProtein == addProtein && anotherBev.numOfFruits == numOfFruits)
			return true;
		return false;
	}
	
	//returns string representing smoothie, formatted as: beverage name,size,whether to add protein,# of fruits,final price
	public String toString() { 
		return String.format("%s,%s,%s,$%.2f", super.toString(), addProtein, numOfFruits, calcPrice());
	}
	
	//calculates final price of smoothie
	public double calcPrice() {
		double total = addSizePrice();
		
		//checks whether to add costs based on extra protein/fruits
		if(addProtein == true)
			total += PROTEIN_PRICE;
		for(int i = 0; i < numOfFruits; i++)	
			total += FRUITS_PRICE;
		return total;
	}
}
