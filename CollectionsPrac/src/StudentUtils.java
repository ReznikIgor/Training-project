import java.util.*;

public class StudentUtils {

	public static Map<String, Student> createMapFromList(List<Student> students) {
		Map<String, Student> studentMap = new HashMap<>();
		for (Student st : students) {
			studentMap.put(st.getFirstName() + st.getLastName(), st);
		}
		return studentMap;
	}

	public static List<Student> getStudentsByCourse(List<Student> students, int course) {
		List<Student> studentsOnCourse = new ArrayList<>();
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student st = iterator.next();
			if (st.getCourse() == course) {
				studentsOnCourse.add(st);
			}
		}
		return studentsOnCourse;
	}

	public static List<Student> sortStudent(List<Student> students) {
		Comparator<Student> comparator = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		};
		Collections.sort(students, comparator);
		return students;
	}

	public static List<Student> getUnique(List<Student> students) {
		List<Student> uniqueList = new ArrayList<>();
		for (Student st : students) {
			if (!uniqueList.contains(st)) {
				uniqueList.add(st);
			}
		}
		return uniqueList;
	}

	public static List<Student> merge(List<Student> oldList, List<Student> newList) {
		Set<Student> expStud = new HashSet<>();
		for (Student st1 : oldList) {
			String firstLastName = st1.getFirstName().concat(st1.getLastName());
			int countSameStud = 0;
			for (Student st2 : newList) {
				String firstAndLastNameSt2 = st2.getFirstName().concat(st2.getLastName());
				if (firstLastName.equalsIgnoreCase(firstAndLastNameSt2)) {
					st1.setCourse(st2.getCourse());
					countSameStud++;
				}
			}
			if (countSameStud == 0) {
				expStud.add(st1);
			}
		}

		Iterator<Student> iterator = oldList.iterator();
		while (iterator.hasNext()) {
			Student st = iterator.next();
			if (expStud.contains(st)) {
				iterator.remove();
			}
		}

		for (Student st : newList) {
			if (!oldList.contains(st)) {
				oldList.add(st);
			}
		}
		return oldList;
	}
}