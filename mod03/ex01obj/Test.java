package mod03.ex01obj;

public class Test {

	public static void main(String[] args) {
		Employee emp = new Administrator("John");
		System.out.println(emp.getInfo());
		System.out.println(emp.getEmpInfo());
	}
}
