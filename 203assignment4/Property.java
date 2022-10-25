
public class Property {

	//fields
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	//constructors
	public Property ()
	{
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
		plot = new Plot();
	}
	
	public Property (String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	public Property (String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	public Property (Property otherProperty)
	{
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot);
	}
	
	//getters and toString methods
	public Plot getPlot()
	{
		Plot plot = new Plot(this.plot);
		return plot;
	}
	public String getPropertyName()
	{
		return propertyName;
	}
	public String getCity()
	{
		return city;
	}
	public double getRentAmount()
	{
		return rentAmount;
	}
	public String getOwner()
	{
		return owner;
	}
	
	public String toString()
	{
		String str = propertyName + "," + city + "," + owner + "," + rentAmount;
		return str;
	}
}
