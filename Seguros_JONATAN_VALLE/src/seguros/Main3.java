package seguros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main3 {
	
	static Conexion c = new Conexion();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		System.out.println("Dime el nombre del asegurado");
		String nombreAsegurado = lector.nextLine();
		System.out.println("Dime el primer apellido del asegurado");
		String apellidoAsegurado1 = lector.nextLine();
		System.out.println("Dime el segundo apellido del asegurado");
		String apellidoAsegurado2 = lector.nextLine();
		
		
		verAsegurado(nombreAsegurado, apellidoAsegurado1, apellidoAsegurado2, "seguros");

	}

	public static void verAsegurado(String n, String a1, String a2, String nDataBase) {
		String sql = " SELECT idSeguro, nombre, ape1, ape2 FROM seguro WHERE nombre = '" + n + "' AND ape1 = '" + a1 + "' AND ape2 = '" + a2 + "'";

		try (Connection conn = c.connect(nDataBase);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			if(rs.next()) {
				System.out.print("Nom del asegurat: ");
				int idSeguro = rs.getInt(1);
				System.out.print(rs.getString(4) + " ");
				System.out.print(rs.getString(3) + " ");
				System.err.print(rs.getString(2) + " ");
				System.out.println();
				//System.out.println(idSeguro);
				cantidadSeguros(idSeguro, nDataBase);
			}else {
				System.out.println("NO EXISTE EL ASEGURADO");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void cantidadSeguros(int idSeguro, String nDataBase) {
		String sql = "SELECT count(*) FROM asistenciamedica WHERE IdSeguro = " + idSeguro;
		
		try (Connection conn = c.connect(nDataBase);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			if(rs.next()) {
				System.out.print("Total assistencia medica: ");
				
				System.out.print(rs.getInt(1));
				System.out.println();
				sumaSeguro(idSeguro, nDataBase);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void sumaSeguro(int idSeguro, String nDataBase) {
		
		String sql = "SELECT SUM(importe) FROM asistenciamedica WHERE IdSeguro = " + idSeguro;
		
		try (Connection conn = c.connect(nDataBase);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			if(rs.next()) {
				System.out.print("Import: ");
				
				System.out.print(rs.getInt(1));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		
		
	}
	}
		
		
}
