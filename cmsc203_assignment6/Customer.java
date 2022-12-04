
public class Customer {
	//variables to hold customer name, age
	private String name;
	private int age;
	
	//constructor given name and age
	public Customer(String name, int age){ 
		this.name = name;
		this.age = age;
	}
	//constructor given another customer object
	public Customer(Customer c)
	{
		name = c.name;
		age = c.age;
	}
	
	//return age
	public int getAge() 
	{ 
		return age;
	}
	
	//set age
	public void setAge(int age) 
	{ 
		this.age = age;
	}
	
	//return name
	public String getName() 
	{
		return name;
	}
	
	//set name
	public void setName(String name) 
	{ 
		this.name = name;
	}
	
	//returns string representing customer, formatted as: name,age
	public String toString() 
	{ 
		return String.format("%s,%d", name, age);
	}
	
}
