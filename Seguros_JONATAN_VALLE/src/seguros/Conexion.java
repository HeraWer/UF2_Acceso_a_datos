package seguros;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {


	// Metodo para la conexion que llamo en cada metodo para conectarme.
	public Connection connect(String nDataBase) {

		String url = "jdbc:mysql://localhost:3306/" + nDataBase
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("Conectado a la base de datos\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
