package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.tables.States;
import db.tables.Tours;
import practice.util.InputHelper;

public class Main {
	private static final String SQL = 
			"SELECT tourId, tourName, price FROM tours WHERE price <= ? ";
	
	public static void main(String[] args) throws SQLException {
		
		double maxPrice;
		try {
			maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
		} catch (NumberFormatException e) {
			System.err.println("Error: invalid number.");
		}
		
		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				PreparedStatement stmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				){
			ResultSet rs = stmt.executeQuery(SQL);
			Tours.displayData(rs);

		} catch (SQLException e) {
			DBUtil.processException(e);

		}
	}

}
