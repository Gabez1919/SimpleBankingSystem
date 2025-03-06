package banking;

public class BankAccount {
	protected String accountNumber;
	protected double balance;
	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance= balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amount) {
		
		if( amount <= 0) {
			System.out.println("Invalid amount");
		}else {
		balance += amount ;
		System.out.println("Succesfully deposited " + amount);
		}
	}
	public void withdraw(double amount) {
		if(amount > balance) {
			System.out.println("Insufficent Funds!Available balance: $ " + balance);
		}
		else if(amount <= 0) {
			System.out.println("Insufficent Wirhdrawal amount!");
			}else {
				balance -= amount ;
				System.out.println("Succusfully withdrew $ " + amount);
				
			}
	
		}
	
	
	public static void main(String[] args) {
		BankAccount a1 = new BankAccount("12345", 1000.0);
		BankAccount a2 = new BankAccount("67890", 500.0);
		System.out.println("Account 1: "+ a1.getAccountNumber() + "|" + a1.getBalance() );
		System.out.println("Account 2: " + a2.getAccountNumber() + "|" + a2.getBalance());
		System.out.println("Depositing $200 into Account 1... ");
		a1.deposit(200.0);
	
		a1.deposit(-50.0);
		
		System.out.println("New Balance: " + a1.getBalance());
		a2.withdraw(700.0);
		System.out.println("Attempting to withdraw $700 from Account 2...");
		System.out.println(a2.getBalance());
		//Testing Saving account
		SavingsAccount s1 = new SavingsAccount("981818" , 1500.0, 2.5);
		s1.applyInterest();
		// Testing Checking Account
		// we used @override
		CheckingAccount c1 = new CheckingAccount("20104" , 20000);
		c1.withdraw(11000);
		c1.withdraw(9000.00);
		

	}

}
