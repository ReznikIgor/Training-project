import java.awt.List;
import java.util.Map;

public class Student {
	private String firstName;
	private String lastName;
	private int course;

	public Student(String firstName, String lastName, int course) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Student student = (Student) o;

		if (course != student.course)
			return false;
		if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null)
			return false;
		return !(lastName != null ? !lastName.equals(student.lastName) : student.lastName != null);
	}

	@Override
	public int hashCode() {
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + course;
		return result;
	}
}
