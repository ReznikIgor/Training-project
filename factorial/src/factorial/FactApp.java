package factorial;

public class FactApp {

	public static void main(String[] args) {
		FactCalc fc = new FactCalc();
		try {
			fc.getFact(20);
		} catch (FactException e) {
			System.out.println(e);
		}
	}

}
