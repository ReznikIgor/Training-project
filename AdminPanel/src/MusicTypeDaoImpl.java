import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MusicTypeDaoImpl implements GenericDao<MusicType, Serializable> {

	@Override
	public MusicType create(MusicType object) throws SQLException {
		String sqlCreate = "INSERT INTO music_type (type_name) VALUES (?)";
		PreparedStatement stmCreate;
		MusicType type = new MusicType();
		try {
			stmCreate = ConnectToDB.getConnection().prepareStatement(sqlCreate, Statement.RETURN_GENERATED_KEYS);
			stmCreate.setString(1, object.getTypeName());
			stmCreate.executeUpdate();

			ResultSet rs = stmCreate.getGeneratedKeys();
			rs.next();
			type.setId(rs.getInt("id"));
			type.setTypeName(object.getTypeName());

			rs.close();
			stmCreate.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public MusicType readById(long key) throws SQLException {
		String sql = "SELECT * FROM music_type WHERE id = ?;";
		PreparedStatement stm;
		MusicType type = new MusicType();
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setLong(1, key);
			ResultSet rs = stm.executeQuery();
			rs.next();
			type.setTypeName(rs.getString("type_name"));
			type.setId(key);
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public void update(MusicType object) throws SQLException {
		String sql = "Update music_type Set type_name = ? where id = ? ";
		PreparedStatement stm;
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setString(1, object.getTypeName());
			stm.setLong(2, object.getId());
			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(MusicType object) throws SQLException {
		String sql = "DELETE FROM music_type WHERE id = ?";
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
