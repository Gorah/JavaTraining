package mod02.ex02;

public class Date {
	public int rok, miesiac, dzien;
	
	public Date (int rok, int miesiac, int dzien) {
		this.rok = rok;
		this.miesiac = miesiac;
		this.dzien = dzien;
	}
	
	public void getDate() {
		System.out.println(this.dzien + "/" + this.miesiac + "/" + this.rok);
	}
	
	public String getInfo(){
		return dzien + "/" + miesiac + "/" + rok;
	}
	
	@Override
	public String toString(){
		return dzien + "/" + miesiac + "/" + rok;
	}
	
}
