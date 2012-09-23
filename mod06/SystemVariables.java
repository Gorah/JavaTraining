package mod06;
import java.util.*;

public class SystemVariables {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		p.list(System.out);
//		System.out.println(p.getProperty("os.name"));
		System.out.println(System.getProperty("os.name"));
	}
}

