import java.util.*;

public class AppStudUtils {

	public static void main(String[] args) {

		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Dick", "Black", 3));
		studentList.add(new Student("Rick", "Brown", 4));
		studentList.add(new Student("Nick", "White", 5));
		studentList.add(new Student("Trick", "Yellow", 6));

		for (Student st : studentList) {
			System.out.println(st.getFirstName());
		}
		System.out.println("----------------------------------");

		Map<String, Student> studentMap = StudentUtils.createMapFromList(studentList);
		for (Student st : studentMap.values()) {
			System.out.println(st.getFirstName());
		}
		System.out.println("----------------------------------");

		List<Student> studentsByCourse = StudentUtils.getStudentsByCourse(studentList, 3);
		for (Student st : studentsByCourse) {
			System.out.println(st.getFirstName() + " " + st.getCourse() + " курс");
		}
		System.out.println("----------------------------------");

		List<Student> sortStudentsByName = StudentUtils.sortStudent(studentList);
		for (Student st : sortStudentsByName) {
			System.out.println(st.getFirstName());
		}
		System.out.println("----------------------------------");

		List<Student> nonUniueStudents = new ArrayList<>();
		nonUniueStudents.add(new Student("Dick", "Black", 6));
		nonUniueStudents.add(new Student("Rick", "Brown", 5));
		nonUniueStudents.add(new Student("Trick", "White", 4));
		nonUniueStudents.add(new Student("Trick", "White", 4));
		nonUniueStudents.add(new Student("Trick", "White", 4));

		List<Student> uniqueStudents = StudentUtils.getUnique(nonUniueStudents);
		for (Student st : uniqueStudents) {
			System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getCourse());
		}
		System.out.println("----------------------------------");

		List<Student> oldList = new ArrayList<>();
		oldList.add(new Student("Rick", "Brown", 3));
		oldList.add(new Student("Dick", "White", 3));
		oldList.add(new Student("Trick", "Black", 5));
		oldList.add(new Student("Nick", "Grey", 5));


		List<Student> newList = new ArrayList<>();
		newList.add(new Student("Rick", "Brown", 3));
		newList.add(new Student("Dick", "White", 3));
		newList.add(new Student("Trick", "Black", 5));
		newList.add(new Student("Nick", "Grey", 5));

		List<Student> mergeList = StudentUtils.merge(oldList, newList);
		for (Student st : mergeList) {
			System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getCourse());
		}
	}

}
