
public class SavingsAccount extends BankAccount{
	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount)
	{
        super(name, amount);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount)
    {
        super(oldAccount, amount);
        savingsNumber = oldAccount.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest() 
    {
        double interest = super.getBalance() * (rate/ 12 / 100);
        super.deposit(interest);
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }
}
