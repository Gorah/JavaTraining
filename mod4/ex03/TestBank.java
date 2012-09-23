package mod4.ex03;

public class TestBank {

	public static void main(String[] args) {
		
		Bank bank1 = Bank.getInstance();
		for (int i=0; i< Bank.MAX_ACCOUNTS; i++){
			bank1.addAccount();
			bank1.payIn(i, 1000);
		}
		
		System.out.println("W banku #1 mamy: " + bank1.getTotalBalance() 
				+ "zl");
		
		Bank bank2 = Bank.getInstance();
		System.out.println("W banku #2 mamy: " + bank2.getTotalBalance()
				+ "zl");
		
		System.out.println(bank1 == bank2);
	}
	
		

}
