package mod01.ex01;
public class Hello {
//	atrybut prywatny
	private String cz2;

	public void sayHello() {
		System.out.println("Hello " + this.cz2);
	}

//	konstruktor klasy
	public Hello() {
		this.cz2 = "World!";	
	}
}