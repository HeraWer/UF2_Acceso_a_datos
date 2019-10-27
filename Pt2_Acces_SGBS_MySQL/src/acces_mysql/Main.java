package acces_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_videoclub?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "1234");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select nombre from socio");
			while (rs.next())
				System.out.println(rs.getString(1));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
