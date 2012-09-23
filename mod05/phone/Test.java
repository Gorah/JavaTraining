package mod05.phone;

public class Test {

    public static void main(String[] args) {
        PrepaidPhone pp = new PrepaidPhone(10);
        for (int i = 0; i < 10; i++) {
            System.out.println("Current limit: " + pp.getLimit());
            try {
				pp.makeCall(8);
			} catch (PrepaidException e) {
//				e.printStackTrace(System.out);
				System.out.println(e.getMessage());
				pp.addToLimit(8);
			}
            pp.addToLimit(3);
        }
        System.out.println("Current limit: " + pp.getLimit());
    }
}