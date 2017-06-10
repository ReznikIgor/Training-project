package factoryWorkers;

public class AppWorkers {

	public AppWorkers() {
	}

	public static void main(String[] args) {
		Director dir1 = new Director("Bob", 28, 2);
		dir1.workersInfo();
		
		StaffMember st1 = new StaffMember("Alex", 24, 2);
		st1.workersInfo();
	}

}
