import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FillTablesRoleAndMusicTypes {
	public static void FillRole() {
		PreparedStatement ps = null;
		Connection conn;
		String sql = "INSERT INTO role (role_name) VALUES (?)";
		try {
			conn = ConnectToDB.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "Registered");
			ps.executeUpdate();
			ps.setString(1, "Moderator");
			ps.executeUpdate();
			ps.setString(1, "Administrator");
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public static void FillMusicType() {
		PreparedStatement ps = null;
		Connection conn;
		String sql = "INSERT INTO music_type (type_name) VALUES (?)";
		try {
			conn = ConnectToDB.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "Rock");
			ps.executeUpdate();
			ps.setString(1, "Rap");
			ps.executeUpdate();
			ps.setString(1, "Club");
			ps.executeUpdate();
			ps.setString(1, "Classic");
			ps.executeUpdate();
			ps.setString(1, "Jazz");
			ps.executeUpdate();
			ps.setString(1, "Funk");
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
			}
		}
	}

}
