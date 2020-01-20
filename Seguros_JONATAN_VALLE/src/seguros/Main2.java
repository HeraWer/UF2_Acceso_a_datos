package seguros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main2 {
	
	static Conexion c = new Conexion();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iniciarDriver();
		modificarImporte("seguros");

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
	
	public static void modificarImporte(String nDataBase) {

		String sql = "UPDATE asistenciamedica SET importe = " + 6523.34 + " where breveDescripcion = " + "'Dermatitis infecciosa'";
		
		try (Connection conn = c.connect(nDataBase);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.executeUpdate(sql);
			System.out.println("Modificacion echa con exito");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
