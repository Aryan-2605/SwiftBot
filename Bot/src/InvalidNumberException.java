
public class InvalidNumberException extends Exception {
	
	public InvalidNumberException() {
		super(Colors.RED + "ERROR: Parameters entered are out of bounds. " + Colors.BLUE_BOLD_BRIGHT);
	
	}
	
	public InvalidNumberException(String message) {
		super(message);
	}
}


