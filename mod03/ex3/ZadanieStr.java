package mod03.ex3;

public class ZadanieStr {

	public static void main(String[] args) {
		String text = "Ala ma 2 koty, a koty maj¹ 1 Alê";
		String wspak = "";
		
		for (int i=text.length()-1; i>=0; i--){
			char znak = text.charAt(i);
			
			if (Character.isLetter(znak)){
				if (Character.isUpperCase(znak)){
					znak = Character.toLowerCase(znak);
				} else {
					znak = Character.toUpperCase(znak);
				}
			}
			
			wspak += znak;
		}
		
		System.out.println(wspak);
	}

}
