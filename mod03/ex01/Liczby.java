package mod03.ex01;

public class Liczby {

	public static void main(String[] args){
		
		int wynik[];
		wynik = new int[7];
		int fib;
		
		fib =0;
		
		for (int i = 1234; i<2346; i++){
				
			if (i%7 == 0){
				wynik[0]++;
				wynik[4]++;
			} else if (i%13 == 0) {
				wynik[1]++;
				wynik[4]++;
			} else if (i%29 == 0) {
				wynik[2]++;
				wynik[4]++;
			} else if (i%43 == 0) {
				wynik[3]++;
				wynik[4]++;
			}
			
			if (i%2 != 0 && i%3 !=0){
				wynik[5]++;
			}
			
						
		}
		
		for (int i=3; i<1200; i++){
			fib = (i-1) + i;
			
			if (fib >= 1234 && fib <= 2345) {
				wynik[6]++;
			}
		}
		
		System.out.println("podzielne prze 7: " + wynik[0]  
				+ "\npodzielne przez 13: " + wynik[1] + "\npodzielne przez 29: "
				+ wynik[2] + "\npodzielne przez 43: " +wynik[3]);
		System.out.println("ilosc podzielnych przez jedna z powyzszych: " + wynik[4]);
		System.out.println("ilosc pierwszych to: " + wynik[5]);
		System.out.println("ilosc fib to: " + wynik[6]);
	}
}
