package mod4.ex03;

public class Account {
	private int number;
	private int balance;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Account(int number, int balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

}
