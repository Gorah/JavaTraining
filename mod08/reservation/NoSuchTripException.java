package mod08.reservation;

public class NoSuchTripException extends Exception {

	public NoSuchTripException() {
	}

	public NoSuchTripException(String message) {
		super(message);
	}

	public NoSuchTripException(Throwable cause) {
		super(cause);
	}

	public NoSuchTripException(String message, Throwable cause) {
		super(message, cause);
	}
}
