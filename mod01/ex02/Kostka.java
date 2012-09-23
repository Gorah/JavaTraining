package mod01.ex02;

public class Kostka {
	public static void main(String[] args) {
		System.out.println("Program wyswietla liczbe oczek wyrzuconych kostka");
			
		// losowanie liczby oczek 
		java.util.Random rnd = new java.util.Random();		
		
//		Random rnd = new Random();
		int liczba = rnd.nextInt(6) + 1;
		
		System.out.println("Wynik to: " + liczba);
	}
}
