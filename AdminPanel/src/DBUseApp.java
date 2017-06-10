import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DBUseApp {
	public static void main(String args[]) {
		FillTablesRoleAndMusicTypes.FillRole();
		FillTablesRoleAndMusicTypes.FillMusicType();
		Role role = new Role(2, "Moderator");
		Address address = new Address(4, "coury", "steeeet", 6122);
		MusicType type1 = new MusicType(1, "rock");
		MusicType type2 = new MusicType(3, "rap");
		Set<MusicType> MT = new HashSet<MusicType>();
		MT.add(type1);
		MT.add(type2);
		User user2 = new User(1, "login", "paword", "ftname", "ltname", 58, address, role, MT);
		UserDaoImpl Ivan2 = new UserDaoImpl();
		try {
			Ivan2.delete(user2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectToDB.closeConn();
	}

}
