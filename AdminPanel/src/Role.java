import java.sql.SQLException;
import java.util.Set;

public class Role {
	private long id;
	private String roleName;

	public Role(long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Role() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
