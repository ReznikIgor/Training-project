
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class RoleDaoImpl implements GenericDao<Role, Serializable> {

	@Override
	public Role create(Role object) {
		String sqlCreate = "INSERT INTO role (role_name) VALUES (?)";
		PreparedStatement stmCreate;
		Role role = new Role();
		try {
			stmCreate = ConnectToDB.getConnection().prepareStatement(sqlCreate, Statement.RETURN_GENERATED_KEYS);
			stmCreate.setString(1, object.getRoleName());
			stmCreate.executeUpdate();
			ResultSet rs = stmCreate.getGeneratedKeys();
			rs.next();
			role.setRoleName(object.getRoleName());
			role.setId(rs.getLong("id"));
			rs.close();
			stmCreate.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return role;
	}

	public Role readById(long key) {
		String sql = "SELECT * FROM role WHERE id = ?;";
		PreparedStatement stm;
		Role role = new Role();
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);

			stm.setLong(1, key);
			ResultSet rs = stm.executeQuery();
			rs.next();
			role.setRoleName(rs.getString("role_name"));
			role.setId(key);
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return role;
	}

	@Override
	public void update(Role object) {
		String sql = "Update role Set role_name = ? where id = ? ";
		PreparedStatement stm;
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setString(1, object.getRoleName());
			stm.setLong(2, object.getId());
			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Role object) {
		String sql = "DELETE FROM role WHERE id = ?";
		PreparedStatement stm;
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setLong(1, object.getId());
			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
