/*
 * Class: CMSC203 
 * Instructor: David Kuijt
 * Description: Simulates a beverage MCCafe, with 
 * BevMCCafe being the store that contains general information, customer and order classes to hold info about each 
 * customer and their order, and beverage and its subclasses to hold information on the beverages that they are
 * buying.
 * Due: 12/03/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Charles Kim
*/

public class BevShopDriverApp {

	public static void main(String[] args) {
		final Day day = Day.MONDAY;
		final int time = 14;
		
		BevShop MCCafe = new BevShop();
		Customer Kujit = new Customer("Kujit", 99);
		Customer ME = new Customer("ME", 2);
		Customer HIM = new Customer("HIM", 26);
		
		
		System.out.println("Start a new order");
		MCCafe.startNewOrder(time, day, Kujit.getName(), Kujit.getAge());
		
		System.out.println("Add alcohol drink");
		MCCafe.processAlcoholOrder("Water", Size.MEDIUM);
		
		System.out.println("Add second alcohol drink");
		MCCafe.processAlcoholOrder("Milk", Size.LARGE);
		
		System.out.println("Add third alcohol drink");
		MCCafe.processAlcoholOrder("Gazpacho + Pie", Size.SMALL);
		
		System.out.println("\nAdd ONE MORE PLEASE! ");
		MCCafe.processAlcoholOrder("Forbidden Alcohol", Size.LARGE);
		
		System.out.println(MCCafe.getCurrentOrder().toString());
		System.out.printf("Your order total is : $%.2f\n", MCCafe.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Start a new order");
		MCCafe.startNewOrder(time, day, ME.getName(), ME.getAge());
		
		System.out.printf("Add a %s to order\n", Type.SMOOTHIE);
		MCCafe.processSmoothieOrder("capuccino", Size.LARGE, 30, true);
		
		System.out.printf("Add a %s to order\n", Type.SMOOTHIE);
		MCCafe.processSmoothieOrder("capuccino", Size.LARGE, 2, true);
		
		System.out.printf("Add a %s to order\n", Type.COFFEE);
		MCCafe.processCoffeeOrder("very berry flurry", Size.SMALL, false, false);
		
		System.out.println("Add alcohol drink");
		MCCafe.processAlcoholOrder("Gazpacho + Pie", Size.SMALL);
		
		System.out.println(MCCafe.getCurrentOrder().toString());
		System.out.printf("Your order total is : $%.2f\n", MCCafe.getCurrentOrder().calcOrderTotal());
		System.out.println("Start a new order");
		MCCafe.startNewOrder(time, day, HIM.getName(), HIM.getAge());
		
		System.out.println("Add alcohol drink");
		MCCafe.processAlcoholOrder("Gazpacho + Pie", Size.SMALL);
		
		System.out.printf("\nTotal amount for all orders: $%.2f\n", MCCafe.totalMonthlySale());
	}

}
