package mod10.ex03;

public class Test {

	public static void main(String[] args) {
		FaxQueue queue = new FaxQueue();
		FaxServer server = new FaxServer(queue);
		FaxClient client = new FaxClient(queue);
		
		Thread serverThread = new Thread(server);
		serverThread.start();
		
		new Thread(client).start();
		new Thread(client).start();
		new Thread(client).start();
		
	}

}
