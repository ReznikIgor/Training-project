package factorial;

public class FactException extends Exception {

	private long detail;

	public FactException(long a) {
		detail = a;
	}

	public String toString() {
	return "Number must be >=0, " + "number is "+ detail;
	}
}
