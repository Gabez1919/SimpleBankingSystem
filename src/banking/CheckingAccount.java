package banking;

public class CheckingAccount extends BankAccount {
	private double withdrawalLimit = 10000;
	public CheckingAccount(String accountNumber, double balance) {
		super(accountNumber,balance);
	}
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	public void setWithdrawalLimit(double withdrawalLimit) {
		this.withdrawalLimit = withdrawalLimit;
	}
	@Override
	public void withdraw(double amount) {
		if(amount > withdrawalLimit) {
			System.out.println("Withdrawal exceeds limit of $ " + withdrawalLimit);
		}else if(amount > balance) {
			System.out.println("Insufficent Funds!Available balance: $ " + balance);
		}else {
			balance -= amount ;
			System.out.println("Succusfully withdrew $ " + amount);
			
		}
	}

}
