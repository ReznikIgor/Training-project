import java.util.Set;
import java.util.TreeSet;

public class AppEmployee {

	public static void main(String[] args) {
		Set<Employee> set = new TreeSet<>();

		set.add(new Employee("Dick", 44, 300));
		set.add(new Employee("Rick", 34, 200));
		set.add(new Employee("Nick", 24, 500));
		set.add(new Employee("Trick", 67, 500));
		set.add(new Employee("Paul", 22, 300));
		for (Employee emp : set) {
			System.out.println(emp.getName());
		}
		System.out.println();
		
		Compare comparator = new Compare();

        Set<Employee> set2 = new TreeSet<>(comparator);

        set2.add(new Employee("Dick", 44, 3500));
        set2.add(new Employee("Rick", 24, 2000));
        set2.add(new Employee("Nick", 44, 8000));
        set2.add(new Employee("Trick", 24, 500));
        set2.add(new Employee("Paul", 23, 12000));

        for(Employee emp : set2){
            System.out.println(emp.getName());
        }
	}
}
