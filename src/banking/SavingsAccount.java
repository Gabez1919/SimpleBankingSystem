package banking;

public class SavingsAccount extends BankAccount {
	private double interestRate;
	public SavingsAccount(String accountNumber , double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public void applyInterest(){
		double interest = balance * (interestRate / 100);
		balance += interest;
		System.out.println("Interest applied !New balance : $ " + balance);
		
	}
}
