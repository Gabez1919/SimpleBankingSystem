package banking;

public class BankAccount {
	private String accountNumber;
	private double balance;
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
		balance += amount ;
	}
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount ;
			}else {
				System.out.println("Insufficent Funds!");
			}
	
	}
	public static void main(String[] args) {
		BankAccount a1 = new BankAccount("12345", 1000.0);
		BankAccount a2 = new BankAccount("67890", 500.0);
		System.out.println("Account 1: "+ a1.getAccountNumber() + "|" + a1.getBalance() );
		System.out.println("Account 2: " + a2.getAccountNumber() + "|" + a2.getBalance());
		
		a1.deposit(200.0);
		System.out.println("Depositing $200 into Account 1... ");
		System.out.println("New Balance: " + a1.getBalance());
		a2.withdraw(700.0);
		System.out.println("Attempting to withdraw $700 from Account 2...");
		System.out.println(a2.getBalance());
		

	}

}
