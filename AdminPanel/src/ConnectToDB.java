import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class ConnectToDB {
	public static Connection conn;
	private static String user = "root";
	private static String password = "toortoor";
	private static String url = "jdbc:mysql://localhost:3306/homedb";
	private int i;

	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = createNewConnection();
		}
		return conn;
	}

	public static Connection createNewConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = (Connection) DriverManager.getConnection(url, user, password);

			} catch (SQLException exception) {
				System.out.println("Ошибка в подкючении к БД " + exception);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Ошибка в подключении Драйверов " + e);
		}
		return conn;
	}

	public static void closeConn() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
