
public class Employee implements Comparable<Employee> {
	private String name;
	private int age;
	private int salary;

	public Employee(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee o) {
		return -this.name.compareTo(o.name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Employee emploee = (Employee) o;

		if (age != emploee.age)
			return false;
		if (salary != emploee.salary)
			return false;
		return !(name != null ? !name.equals(emploee.name) : emploee.name != null);

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + age;
		result = 31 * result + salary;
		return result;
	}
}
