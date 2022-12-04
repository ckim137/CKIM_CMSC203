import java.util.ArrayList;
public class Order implements OrderInterface, Comparable<Order> {
	//variables for order time, order day, order number, and customer
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private int orderNo;
	
	//list to hold beverages
	ArrayList<Beverage> bev = new ArrayList<Beverage>();
	
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.orderNo = generateOrder();
	}
	
	public Order(Order anotherOrder)
	{
		orderTime = anotherOrder.orderTime;
		orderDay = anotherOrder.orderDay;
		cust = new Customer(anotherOrder.cust);
		bev.addAll(anotherOrder.bev);
		orderNo = anotherOrder.orderNo;
	}
	
	//generates random order number (conflicts with compareTo method (?))
	public int generateOrder()
	{ 
		orderNo = (int)(Math.random()*(90000-10000+1)+ 10000);
		return orderNo;
	}
	
	//returns order number
	public int getOrderNo() 
	{ 
		return orderNo;
	}
	
	//returns time of order
	public int getOrderTime() 
	{ 
		return orderTime;
	}
	
	//returns day of order
	public Day getOrderDay() 
	{ 
		return orderDay;
	}
	
	//returns customer
	public Customer getCustomer()
	{
		return cust;
	}
	
	//returns day of order
	public Day getDay() 
	{ 
		return orderDay;
	}
	
	//returns whether it is weekend or not
	public boolean isWeekend() 
	{
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
			return true;
		return false;
	}
	
	public Beverage getBeverage(int itemNo) 
	{
		try
		{
			//try to return shallow copy of beverage from list
			return bev.get(itemNo);
		}
		//if the index is out of bounds, return null
		catch(ArrayIndexOutOfBoundsException e) 
		{
			return null;
		}
	}
	
	//returns # of beverages
	public int getTotalItems()
	{
		return bev.size();
	}
	
	//adds new coffee to list
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		bev.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	//adds new alcohol to list
	public void addNewBeverage(String bevName, Size size)
	{
		bev.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	//adds new smoothie to list
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		bev.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	//calculates total price 
	public double calcOrderTotal()
	{
		double total = 0;
		for(int i = 0; i < bev.size(); i++){
			total += bev.get(i).calcPrice();
		}
		return total;
	}
	
	//returns # of certain type of beverage in list
	public int findNumOfBeveType(Type type) 
	{
		int count = 0;
		for(int i = 0; i < bev.size(); i++) 
		{
			if(bev.get(i).getType() == type)
				count++;
		}
		return count;
	}
	
	//returns representation of order
	public String toString() 
	{
		String bevList = "";
		for(int i = 0; i < bev.size(); i++) 
		{
			bevList += bev.get(i).toString() + "\n";
		}
		return String.format("Order#: %d\nTime: %d\nDay: %s\nCustomer Info: %s\nBeverage Info: %s", orderNo, orderTime, orderDay, cust.toString() ,bevList);
	}

	//checks whether order number is less than or greater than other beverage's order number
	//(why are we doing this if the order number is generated randomly???)
	public int compareTo(Order anotherOrder)
	{
		if(anotherOrder.orderNo < orderNo)
			return -1;
		if(anotherOrder.orderNo > orderNo)
			return 1;
		return 0;
	}


	
}
