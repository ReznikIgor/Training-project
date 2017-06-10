package factoryWorkers;

public class StaffMember extends Worker {
	private static int rateOfSalary = 200;
	private int bonusSalary;
	private static String position = "Staff";
	
	StaffMember(String name, int age, int workExperience) {
		super(name, age, workExperience, rateOfSalary, position);

	}
	private void bonus(){
		if(super.age < 30 && super.age > 18){
			bonusSalary = 23;
		}
		System.out.println("Bonus salary is " + bonusSalary);
		
	}
	@Override
	public void workersInfo() {
		super.workersInfo();
		bonus();
		System.out.println("_____________________________");

	}

}
