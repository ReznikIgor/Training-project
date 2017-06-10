import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mysql.jdbc.Statement;

public class UserDaoImpl implements GenericDao<User, Serializable> {

	@Override
	public User create(User object) throws SQLException {
		String sql = "INSERT INTO user (login, password, first_name, last_name, age, role_id) VALUES(?, ?, ?, ?, ?, ?);";
		String sqlMT = "INSERT INTO user_musictype (user_id, music_type_id) VALUES (?, ?)";
		Address address = new Address();
		AddressDaoImpl addressDao = new AddressDaoImpl();

		try {
			PreparedStatement stm = ConnectToDB.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, object.getLogin());
			stm.setString(2, object.getPassword());
			stm.setString(3, object.getFirstName());
			stm.setString(4, object.getLastName());
			stm.setInt(5, object.getAge());
			stm.setLong(6, object.getRole().getId());

			stm.executeUpdate();

			ResultSet rs = stm.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				object.setId(id);
				address.setId(id);
				address.setCountry(object.getAddress().getCountry());
				address.setStreet(object.getAddress().getStreet());
				address.setZipCode(object.getAddress().getZipCode());
				addressDao.create(address);

				PreparedStatement stm2 = ConnectToDB.getConnection().prepareStatement(sqlMT);
				for (MusicType musicType : object.getMusicType()) {
					stm2.setLong(1, id);
					stm2.setLong(2, musicType.getId());
					stm2.executeUpdate();
				}
				stm2.close();
			} else {
				System.out.println("Can't get auto incremement data");
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public User readById(long key) throws SQLException {
		User user = new User();
		String sql = "SELECT * FROM user WHERE id = ?;";
		String getMusicType = "SELECT * FROM user_musictype WHERE user_id = ?;";
		PreparedStatement stmUser;
		PreparedStatement stmMusType;
		AddressDaoImpl address = new AddressDaoImpl();
		MusicTypeDaoImpl musicType = new MusicTypeDaoImpl();
		RoleDaoImpl role = new RoleDaoImpl();
		Set<MusicType> musicTypes = new HashSet<MusicType>();
		long roleId;
		long musicTypeId;
		try {
			stmUser = ConnectToDB.getConnection().prepareStatement(sql);
			stmUser.setLong(1, key);

			ResultSet rs = stmUser.executeQuery();
			rs.next();
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setAge(rs.getInt("age"));
			roleId = rs.getLong("role_id");

			user.setAddress(address.readById(key));
			user.setRole(role.readById(roleId));

			stmMusType = ConnectToDB.getConnection().prepareStatement(getMusicType);
			stmMusType.setLong(1, key);
			ResultSet rsMus = stmMusType.executeQuery();
			while (rsMus.next()) {
				musicTypeId = (rsMus.getLong("music_type_id"));
				musicTypes.add(musicType.readById(musicTypeId));
			}
			user.setMusicType(musicTypes);
			rsMus.close();
			rs.close();
			stmUser.close();
			stmMusType.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public void update(User object) throws SQLException {
		String sql = "Update user Set login = ?, password = ?, first_name = ?, last_name = ?, age = ?, role_id = ? where id = ? ";
		String delMusType = "DELETE FROM user_musictype where user_id = ?;";
		String updMusType = "INSERT INTO user_musictype (user_id, music_type_id) VALUES(?, ?);";
		Address address = new Address();
		AddressDaoImpl addressDao = new AddressDaoImpl();
		MusicTypeDaoImpl musicType = new MusicTypeDaoImpl();
		RoleDaoImpl role = new RoleDaoImpl();
		PreparedStatement stm;
		PreparedStatement delMusicType;
		PreparedStatement setMusicType;
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setString(1, object.getLogin());
			stm.setString(2, object.getPassword());
			stm.setString(3, object.getFirstName());
			stm.setString(4, object.getLastName());
			stm.setInt(5, object.getAge());
			stm.setLong(6, object.getRole().getId());
			stm.setLong(7, object.getId());

			address.setCountry(object.getAddress().getCountry());
			address.setStreet(object.getAddress().getStreet());
			address.setZipCode(object.getAddress().getZipCode());
			address.setId(object.getId());

			addressDao.update(address);

			delMusicType = ConnectToDB.getConnection().prepareStatement(delMusType);
			delMusicType.setLong(1, object.getId());
			delMusicType.executeUpdate();
			delMusicType.close();

			setMusicType = ConnectToDB.getConnection().prepareStatement(updMusType);
			for (MusicType mus : object.getMusicType()) {
				setMusicType.setLong(1, object.getId());
				setMusicType.setLong(2, mus.getId());
				setMusicType.executeUpdate();
			}
			setMusicType.close();

			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(User object) throws SQLException {
		String sql = "DELETE FROM user WHERE id = ?";
		String delMus = "DELETE FROM user_musictype WHERE user_id = ?;";
		Address address = new Address();
		AddressDaoImpl addressDao = new AddressDaoImpl();

		PreparedStatement stm;
		PreparedStatement deleteMusicType;
		try {
			address.setId(object.getId());
			addressDao.delete(address);

			deleteMusicType = ConnectToDB.getConnection().prepareStatement(delMus);
			deleteMusicType.setLong(1, object.getId());
			deleteMusicType.executeUpdate();
			deleteMusicType.close();

			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setLong(1, object.getId());

			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User readByLogin(String login) {
		String sql = "SELECT * FROM user WHERE login = ?;";
		RoleDaoImpl role = new RoleDaoImpl();
		long roleId;
		User user = new User();
		PreparedStatement stm;
		try {
			stm = ConnectToDB.getConnection().prepareStatement(sql);
			stm.setString(1, login);

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				user.setLogin(login);
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAge(rs.getInt("age"));
				roleId = rs.getLong("role_id");
				user.setRole(role.readById(roleId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM user;";
		Statement stm = null;
		String getMusicType = "SELECT * FROM user_musictype WHERE user_id = ?;";
		PreparedStatement stmMusType;

		try {

			stm = (Statement) ConnectToDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				Long roleId;
				long musicTypeId;
				AddressDaoImpl address = new AddressDaoImpl();
				MusicTypeDaoImpl musicType = new MusicTypeDaoImpl();
				Set<MusicType> musicTypes = new HashSet<MusicType>();
				RoleDaoImpl role = new RoleDaoImpl();

				user.setId(rs.getLong("id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAge(rs.getInt("age"));
				roleId = rs.getLong("role_id");
				user.setRole(role.readById(roleId));
				user.setAddress(address.readById(rs.getLong("id")));

				stmMusType = ConnectToDB.getConnection().prepareStatement(getMusicType);
				stmMusType.setLong(1, rs.getLong("id"));
				ResultSet rsMus = stmMusType.executeQuery();
				while (rsMus.next()) {
					musicTypeId = (rsMus.getLong("music_type_id"));
					musicTypes.add(musicType.readById(musicTypeId));
				}
				user.setMusicType(musicTypes);
				users.add(user);
				rsMus.close();
				stmMusType.close();

			}
			rs.close();
			stm.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return users;

	}

}
