package mod03.ex2;

import java.util.Random;

public class ArrCopy {
	public static void main(String[] args) {
		int[] tablica;
		int[] tablica2;
		
		tablica = new int[5000000];
		tablica2 = new int[5000000];
		Random rnd = new Random();
        int liczba;  
		
		
		for (int i=0; i<5000000; i++){
			liczba = rnd.nextInt(90)+10;
			tablica[i] = liczba;
		}
		
		long sTime = System.currentTimeMillis();
		
		for (int i=0; i<tablica.length; i++){
			tablica2[i] = tablica[i];
		}
		
		long eTime = System.currentTimeMillis();
		
		
		System.out.println(eTime - sTime + "ms");
		
		sTime = System.nanoTime();
		
		System.arraycopy(tablica, 0, tablica2, 0, tablica.length);
		eTime = System.nanoTime();
		System.out.println((eTime - sTime)/1000000 + "ms");
	}
	
	
}
