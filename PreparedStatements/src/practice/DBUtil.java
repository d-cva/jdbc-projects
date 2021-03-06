package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String USERNAME = "shiva";
	private static final String PASSWORD = "password";
	private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
	private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static Connection getConnection(DBType dbType) throws SQLException {
		switch (dbType) {
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
			default:
			return null;
		}
	}
	public static void processException(SQLException e) {
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
		System.err.println("SQL State: " + e.getSQLState());
	}
}
