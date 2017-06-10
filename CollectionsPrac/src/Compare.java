import java.util.Comparator;

public class Compare implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int res;
		if (o1.getAge() > o2.getAge() || o1.getAge() < o2.getAge()) {
			res = o1.getAge() > o2.getAge() ? 1 : -1;
		} else if (o1.getSalary() > o2.getSalary() || o1.getSalary() < o2.getSalary()) {
			res = o1.getSalary() > o2.getSalary() ? 1 : -1;
		} else {
			res = o1.getName().compareTo(o2.getName());
		}
		return res;
	}

}
