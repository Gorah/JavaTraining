package mod02.ex01b;

import java.util.Random;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kostka {
	public static void main(String[] args) {
		System.out.println("Program wyswietla liczbe oczek wyrzuconych kostka");
                System.out.println("Podaj ilosc scianek: ");
                
                InputStreamReader streamer = new InputStreamReader(System.in);               
                BufferedReader r = new BufferedReader(streamer);

                String result = null;
                try {
                    result = r.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Kostka.class.getName()).log(Level.SEVERE,
                    		null, ex);
                }
                int val = Integer.parseInt(result);
		// losowanie liczby oczek
                Random rnd = new Random();
                int liczba = rnd.nextInt(val) + 1;

		System.out.println("Wynik to: " + liczba);
        }
}

