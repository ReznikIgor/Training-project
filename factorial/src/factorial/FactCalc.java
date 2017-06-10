package factorial;

public class FactCalc {
	private long result = 1;

	private long calcFactorial(long number) throws FactException {
		if (number == 0) {
			result = 1;
		} else if (number < 0) {
			throw new FactException(number);
		}

		else {
			for (int i = 1; i <= number; i++) {
				result = result * i;
			}

		}
		return result;
	}

	public void getFact(long factorial) throws FactException {
		System.out.println(calcFactorial(factorial));
	}

}
