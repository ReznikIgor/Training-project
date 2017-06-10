import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressDaoImpl implements GenericDao<Address, Serializable> {

	@Override
	public Address create(Address object) {
		String sqlCreate = "INSERT INTO address (country, street, zip, id) VALUES (?,?,?,?)";

		PreparedStatement stmCreate;

		Address address = new Address();
		try {
			stmCreate = ConnectToDB.getConnection().prepareStatement(sqlCreate);
			stmCreate.setString(1, object.getCountry());
			stmCreate.setString(2, object.getStreet());
			stmCreate.setInt(3, object.getZipCode());
			stmCreate.setLong(4, object.getId());
			stmCreate.executeUpdate();

			Statement stmGet = ConnectToDB.getConnection().createStatement();
			String sqlGet = "SELECT * FROM address";
			ResultSet rs = stmGet.executeQuery(sqlGet);
			rs.next();
			address.setId(rs.getInt("id"));
			address.setCountry(object.getCountry());
			address.setStreet(object.getStreet());
			address.setZipCode(object.getZipCode());
			rs.close();
			stmCreate.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return address;

	}

	@Override
	public Address readById(long key) throws SQLException {
		String sql = "SELECT * FROM address WHERE id = ?;";
		PreparedStatement stm;
		Address address = new Address();
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setLong(1, key);
			ResultSet rs = stm.executeQuery();
			rs.next();
			address.setId(key);
			address.setCountry(rs.getString("country"));
			address.setStreet(rs.getString("street"));
			address.setZipCode(rs.getInt("zip"));
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public void update(Address object) {
		String sql = "Update address Set country = ?, street = ?, zip = ? where id = ? ";
		PreparedStatement stm;
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setString(1, object.getCountry());
			stm.setString(2, object.getStreet());
			stm.setInt(3, object.getZipCode());
			stm.setLong(4, object.getId());
			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Address object) {
		String sql = "DELETE FROM address WHERE id = ?";
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
