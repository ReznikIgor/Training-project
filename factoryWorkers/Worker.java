package factoryWorkers;

public class Worker {
	public String name;
	public int age;
	public int rateOfSalary;
	public int workExperience;
	public int salary;
	public String position;
	public static final int workingHours = 8;

	Worker(String name, int age, int workExperience, int rateOfSalary, String position) {
		this.rateOfSalary = rateOfSalary;
		this.position = position;
		this.name = name;
		this.age = age;
		this.workExperience = workExperience;
	}

	public void calcSalary(int rateOfSalary) {
		this.rateOfSalary = rateOfSalary;
		int salaryIndex;

		if (workExperience > 0 && workExperience < 1) {
			salaryIndex = 1;

			salary = rateOfSalary * workingHours * salaryIndex;
		} else if (workExperience > 1 && workExperience < 5) {
			salaryIndex = 2;

			salary = rateOfSalary * workingHours * salaryIndex;
		} else if (workExperience > 5 && workExperience < 60) {
			salaryIndex = 3;

			salary = rateOfSalary * workingHours * salaryIndex;
		}
		System.out.println("Worker salary now is " + salary + "$");
	}

	public void workersInfo() {

		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Position: " + position);
		calcSalary(rateOfSalary);
		
	}

}
