/*
 * Class: CMSC203 
 * Instructor: Kujit
 * Description: Plot class manages a Plot object that is used by each property, representing
 * the space/location they take up on the GUI. Property class manages Property objects,
 * each with their own plot, and are distinguished by their names, city, and rent.
 * ManagementCompany class manages the companies that own each property, and employs several methods including finding the 
 * property with the highest rent, adding and removing properties, and more
 * Due: 10/24/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Charles Kim
*/

public class ManagementCompany {
	//fields
	private String name;
	private String taxID;
	private double mgmFee;
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	private Plot plot;
	private Property[] properties;
	private int numberOfProperties;
	
	//constructors
	public ManagementCompany()
	{
		name = "";
		taxID = "";
		mgmFee = 0.0;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < MAX_PROPERTY; i++) {
			properties[i] = new Property();
		}
		numberOfProperties = 0;
	}
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < MAX_PROPERTY; i++) {
			properties[i] = new Property();
		}
		numberOfProperties = 0;
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < MAX_PROPERTY; i++) {
			properties[i] = new Property();
		}
		numberOfProperties = 0;
	}
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = new Plot(otherCompany.plot);
		this.numberOfProperties = otherCompany.numberOfProperties;
		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < otherCompany.numberOfProperties; i++)
		{
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
	}
	//simple getters
	public String getName()
	{
		return name;
	}
	public String getTaxID()
	{
		return taxID;
	}
	public double getMgmFeePer()
	{
		return mgmFee;
	}
	public Property[] getProperties()
	{
		Property[] newProperties = new Property[MAX_PROPERTY];
		for(int i = 0; i < MAX_PROPERTY; i++)
		{
			newProperties[i] = new Property(properties[i]);
		}
		return newProperties;
	}
	public Plot getPlot()
	{
		Plot newPlot = new Plot(plot);
		return newPlot;
	}
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	
	//other getters
		public Property getHighestRentPropperty()
		{
			double maxRent = 0.0;
			int index = 0;
			for(int i = 0; i < MAX_PROPERTY; i++)
			{
				if(properties[i].getRentAmount() > maxRent)
				{
					maxRent = properties[i].getRentAmount();
					index = i;
				}
			}
			return properties[index];
		}
		
		public double getTotalRent()
		{
			double total = 0;
			for(int i = 0; i < MAX_PROPERTY; i++)
			{
				total += properties[i].getRentAmount();
			}
			return total;
		}
	//addProperty methods
	public int addProperty(Property property) {
		
		//check whether property is null, check whether properties array is full
		if(property == null)
			return -2;
		else if(isPropertiesFull())
			return -1;
		
		//if property array isn't full, then numberOfProperties is next index that is empty. create new Property at this index
		properties[numberOfProperties] = new Property(property);
		
		//Here, check whether the plot overlaps/encompasses other plots. If it overlaps/doesn't encompass, deletes Property
		 if(!plot.encompasses(properties[numberOfProperties].getPlot()))
		 {
			properties[numberOfProperties] = null; 
			return -3;
		 }
		 
		 //check whether plot overlaps any of properties, if so, removes the new Property
		for(int i = 0; i < numberOfProperties; i++)
		{
			if(properties[numberOfProperties].getPlot().encompasses(properties[i].getPlot()))
			{
				properties[numberOfProperties] = null;
				return -4;	
			}
		}
		
		//if it passes all tests, the property stays, # of properties go up, and return index of property
		numberOfProperties++;
		return (numberOfProperties-1);
		
	}
	public int addProperty(String name, String city, double rent, String owner) {
		Property temp = new Property(name, city, rent, owner);
		return addProperty(temp);
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property temp = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(temp);
	}
	
	//other methods
	public void removeLastProperty()
	{
		properties[numberOfProperties] = null;
		numberOfProperties--;
	}
	public boolean isPropertiesFull()
	{
		if(numberOfProperties == MAX_PROPERTY)
			return true;
		return false;
	}
	public boolean isManagementFeeValid()
	{
		if(mgmFee < 0 || mgmFee > 100)
			return false;
		return true;
	}
	public String toString()
	{
		String str = "";
		Property tempProperty = new Property();
		str += "List of the properties for " + name + ", taxID: " + taxID + 
				"\n______________________________________________________\n";
		for(int i = 0; i < numberOfProperties; i++)
		{
			tempProperty = new Property(properties[i]);
			str += tempProperty.getPropertyName() + "," + tempProperty.getCity() + "," + tempProperty.getOwner() + "," +
			tempProperty.getRentAmount() + "\n";
		}
		str += "______________________________________________________\n";
		str += "total management Fee: " + mgmFee;
		return str;
	}
}
