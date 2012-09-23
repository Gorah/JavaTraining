package mod08.reservation;

public class NoSuchCustomerException extends Exception {

	public NoSuchCustomerException() {
	}

	public NoSuchCustomerException(String message) {
		super(message);
	}

	public NoSuchCustomerException(Throwable cause) {
		super(cause);
	}

	public NoSuchCustomerException(String message, Throwable cause) {
		super(message, cause);
	}
}
