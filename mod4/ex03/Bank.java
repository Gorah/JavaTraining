package mod4.ex03;

public class Bank {
	private static Bank instance = null;
	public static final int MAX_ACCOUNTS = 100;
	private Account[] accounts = new Account[MAX_ACCOUNTS];
	private int currentAccount = 0;
	
	private Bank() {

	}

	public static Bank getInstance() {
		if (null == instance){
			instance= new Bank();
		}
		return instance;
	}
	
	public void addAccount(){
		accounts[currentAccount++] = new Account(currentAccount, 0);
	}
	
	public int getAccountsNumber(){
		return currentAccount;
	}
	
	
	public boolean payIn(int number, int amount){
		if(number >= currentAccount){
			return false;
		}
		accounts[number].setBalance(accounts[number].getBalance() + amount);	
		return true;
		
	}
	
	public boolean payOut(int number, int amount){
		if(number >= currentAccount){
			return false;
		}
		int balance = accounts[number].getBalance(); 
		if(amount > balance){
			return false;
		}
		accounts[number].setBalance(balance - amount);
		return true;
	}
	
	public double getTotalBalance(){
		double total = 0;
		for (Account i: accounts) {
			total +=i.getBalance();
		}
		
		return total;
	}
}
