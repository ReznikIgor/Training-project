package factoryWorkers;

public class Director extends Worker {
	private static int rateOfSalary = 500;
	private static String position = "Director";

	Director(String name, int age, int workExperience) {
		super(name, age, workExperience, rateOfSalary, position);

	}

	private void timeToRetirement() {
		int yearsToRet = 0;
		if (super.age < 65 && super.age > 18) {

			yearsToRet = 65 - super.age;
		} else if (super.age > 65) {
			System.out.println("It's time to retirement");
		} else {
			System.out.println("Wrong age");
		}
		System.out.println("Time to retirement is " + yearsToRet + " years");

	}

	@Override
	public void workersInfo() {
		super.workersInfo();
		timeToRetirement();
		System.out.println("_____________________________");
	}

}
