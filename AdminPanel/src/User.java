import java.util.Set;

public class User {
	private long id;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	private Role role;
	private Set<MusicType> musicType;

	public User(long id, String login, String password, String firstName, String lastName, int age, Address address,
			Role role, Set<MusicType> musicType) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.role = role;
		this.musicType = musicType;
	}

	public User() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<MusicType> getMusicType() {
		return musicType;
	}

	public void setMusicType(Set<MusicType> musicType) {
		this.musicType = musicType;
	}

}
