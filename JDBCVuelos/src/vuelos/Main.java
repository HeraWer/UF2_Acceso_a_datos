package vuelos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iniciarDriver();
		//insertarDepartamento("vuelos");
		//createProcedure("vuelos");
		llamarProcedure("Comandante", "vuelos");
	}

	// Metodo para iniciar el driver de mysql al iniciar el programa
	public static void iniciarDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver iniciado\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo para la conexion que llamo en cada metodo para conectarme.
	private static Connection connect(String nDataBase) {

		String url = "jdbc:mysql://localhost:3306/" + nDataBase
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado a la base de datos\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// Metodo para insertar un nuevo socio
	public static void insertarDepartamento(String nDataBase) {
		System.out.println();
		String sql = "INSERT INTO personal (codigo, nombre, categoria) VALUES (?,?,?)";

		try (Connection conn = connect(nDataBase);

				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, 1);
			pstmt.setString(2, "DEVOPS");
			pstmt.setString(3, "Desarrollo");
			pstmt.executeUpdate();
			System.out.println("Insertado en la tabla con exito!");
			System.out.println("Volviendo al menu....");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Volviendo a menu");
		}
	}
	
	public static void createProcedure(String nDataBase) {
		String procedure = "CREATE PROCEDURE sacar_personal (IN puesto VARCHAR(20))"
				+ " BEGIN "
				+ " SELECT * FROM personal WHERE categoria = puesto; "
				+ " END";
	
		try (Connection conn = connect(nDataBase);
				PreparedStatement pstmt = conn.prepareStatement(procedure)){
			pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public static void llamarProcedure(String puesto, String nDataBase) {
		try (Connection conn = connect(nDataBase)){
			CallableStatement sp = conn.prepareCall("{call sacar_personal ('" + puesto +"')}");
			
			ResultSet rs = sp.executeQuery();
			
			if(rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
