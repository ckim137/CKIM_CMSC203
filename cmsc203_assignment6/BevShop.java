import java.util.ArrayList;
public class BevShop implements BevShopInterface {
	//variable to count # of alcohol for current order
	private int numOfAlcoholDrink = 0;

	
	//list to count # of orders
	ArrayList<Order> orders = new ArrayList<Order>();
	
	//default constructor
	public BevShop() {
	}
	
	//checks whether the time is valid
	public boolean isValidTime(int time) 
	{
		if(time >= MIN_TIME && time <= MAX_TIME)
			return true;
		return false;
	}

	//returns max # of fruits
	public int getMaxNumOfFruits() 
	{
		return MAX_FRUIT;
	}

	//returns min alcohol age
	public int getMinAgeForAlcohol() 
	{
		return MIN_AGE_FOR_ALCOHOL;
	}

	//checks whether current beverage has max # of fruits
	public boolean isMaxFruit(int numOfFruits) 
	{
		if(numOfFruits >= MAX_FRUIT)
			return true;
		return false;
	}

	//returns max # of alcohol that can be ordered
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}

	//checks whether current order is eligible for more alcohol 
	public boolean isEligibleForMore()
	{
		if(numOfAlcoholDrink < MAX_ORDER_FOR_ALCOHOL)
			return true;
		return false;
	}

	//returns # of alcohol for current order
	public int getNumOfAlcoholDrink()
	{
		return numOfAlcoholDrink;
	}

	//checks whether customer is of age
	public boolean isValidAge(int age) 
	{
		if(age >= MIN_AGE_FOR_ALCOHOL)
			return true;
		return false;
	}

	//finds order in list based on order number
	public int findOrder(int orderNo) 
	{
		for(int i = 0; i < orders.size(); i++) 
		{
			if(orderNo == orders.get(i).getOrderNo())
				return i;
		}
		//if can't be found, return -1
		return -1;
	}

	//returns total price of order
	public double totalOrderPrice(int orderNo) 
	{
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	//returns total money made during month
	public double totalMonthlySale() 
	{
		double total = 0;
		for(int i = 0; i < orders.size(); i++) 
		{
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}

	//returns total # of orders made during month
	public int totalNumOfMonthlyOrders() 
	{
		return orders.size();
	}

	//returns latest/current order
	public Order getCurrentOrder() 
	{
		return orders.get(orders.size() - 1);
	}

	//returns order at index
	public Order getOrderAtIndex(int index) 
	{
		try{
			//tries to return order at list index
			return orders.get(index);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			//if index is out of bounds, returns null
			return null;
		}
	}

	//sorts orders based on total amount of money made, lowest to highest, using selection sort
	public void sortOrders()
	{
		for(int i = 0; i < orders.size() - 1; i++)
		{ 
			int minIndex = i;
			for(int j = i + 1; j < orders.size(); j++)
			{
				//goes through each index in array, checking whether the other orders have a lower total price than the current index
				if(orders.get(j).calcOrderTotal() < orders.get(minIndex).calcOrderTotal())
					minIndex = j;
				
				//creates deep copy of each order that is being swapped, then swaps the orders
				Order temp = new Order(orders.get(minIndex));
				orders.set(minIndex, new Order(orders.get(i)));
				orders.set(i, new Order(temp));
			}
		}
	}
	
	//add new order to list, (NO BEVERAGE IS ADDED JUST YET, JUST ORDER INFO)
	public void startNewOrder(int time, Day day, String customerName, int customerAge) 
	{
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
		numOfAlcoholDrink = 0;
	}

	//add/process new coffee order
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		getCurrentOrder().bev.add(new Coffee(bevName, size, extraShot, extraSyrup));
		System.out.println("Drink added.\n");
	}

	//add/process new alcohol order
	public void processAlcoholOrder(String bevName, Size size)
	{
		//check whether order already has max # of alcohol or whether customer is underage
		if(isEligibleForMore() && isValidAge(getCurrentOrder().getCustomer().getAge())) 
		{
			getCurrentOrder().bev.add(new Alcohol(bevName, size, false)); //interface is missing isWeekend parameter, so just setting it as false here.
			numOfAlcoholDrink++;
			System.out.println("Drink added.\n");
		}
		
		//check whether age is valid
		else if(!isValidAge(getCurrentOrder().getCustomer().getAge()))
			System.out.println("Age not appropriate for alcohol drink!!!");
		//check whether current order has already ordered max amount of alcohol
		else
			System.out.println("Maximum alcohol drink for this order");
	}

	//add/process new smoothie order
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		//check whether numOfFruits exceeds max # of fruits
		if(!isMaxFruit(numOfFruits))
		{
		getCurrentOrder().bev.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		System.out.println("Drink added.\n");
		}
		else
			System.out.println("# of Fruits exceeds Max amount of fruits allowed!!!");
	}

}
