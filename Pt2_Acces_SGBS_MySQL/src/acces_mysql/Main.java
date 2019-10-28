package acces_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	Socio soc = new Socio();
	static Main m = new Main();

	// Main
	public static void main(String[] args) {

		m.iniciarDriver();
		// m.selectSamurais(nDataBase);
		m.menu();

	}

	// Metodo para iniciar el driver de mysql al iniciar el programa
	public void iniciarDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver iniciado\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo para la conexion que llamo en cada metodo para conectarme.
	private Connection connect(String nDataBase) {

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

	// Metodo de prueba para comprobar cosas.

	/*
	 * public void selectSamurais(String nDataBase) { System.out.println(); String
	 * sql = "select nombre from socio";
	 * 
	 * try (Connection conn = this.connect(nDataBase); Statement stmt =
	 * conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
	 * 
	 * // loop through the result set while (rs.next()) {
	 * System.out.println(rs.getString("nombre")); } } catch (SQLException e) { //
	 * System.out.println(e.getMessage()); } }
	 */

	// Metodo para recoger datos lleno de comprobaciones
	public void recogerDatos() {
		Scanner lector = new Scanner(System.in);
		boolean cDatos = true;
		String datoS = null;
		int datoI = 0;
		System.out.println("Dime el nombre del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 21) {
				soc.setNombre(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 20 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime los apellidos del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 21) {
				soc.setApellidos(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 20 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime la direccion del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 21) {
				soc.setDireccion(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 20 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime el telefono del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 11) {
				soc.setTelefono(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 10 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime la poblacion del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 31) {
				soc.setPoblacion(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 30 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime el CP del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 6) {
				soc.setCp(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 5 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime la provincia del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 21) {
				soc.setProvincia(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 20 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime el pais del socio");
		while (cDatos) {
			datoS = lector.nextLine();
			if (datoS.length() < 11) {
				soc.setPais(datoS);
				cDatos = false;
			} else {
				System.out.println("Solo admite 10 caracteres");
			}
		}

		cDatos = true;
		System.out.println("Dime la edad del socio");
		while (cDatos) {
			if (lector.hasNextInt()) {
				datoI = lector.nextInt();
				soc.setEdad(datoI);
				cDatos = false;
			} else {
				System.out.println("No es un entero");
				lector.next();
			}
		}
		cDatos = true;
		System.out.println("Dime la fecha de alta del socio ( formato : YYYY-MM-DD )");
		while (cDatos) {
			System.out.println("Escribe el año");
			String aux = lector.nextLine();
			if (aux.length() == 4) {
				datoS = aux + "-";
				System.out.println("Escribe el mes");
				aux = "";
				aux = lector.nextLine();
				if (aux.length() == 2) {
					datoS = datoS + aux + "-";
					System.out.println("Escribe el dia");
					aux = "";
					aux = lector.nextLine();
					if (aux.length() == 2) {
						datoS = datoS + aux;
						soc.setFechaalta(datoS);
						cDatos = false;
					} else {
						System.out.println("El mes se compone de 2 cifras");
					}
				} else {
					System.out.println("El mes se compone de 2 cifras");
				}
			} else {
				System.out.println("El año se compone de 4 cifras");
			}
		}

		cDatos = true;
		System.out.println("Dime la cuota del socio");
		while (cDatos) {
			if (lector.hasNextInt()) {
				datoI = lector.nextInt();
				soc.setCuota(datoI);
				cDatos = false;
			} else {
				System.out.println("No es un entero");
				lector.next();
			}
		}

		// System.out.println(soc.getNombre() + soc.getApellidos() + soc.getDireccion()
		// + soc.getTelefono() + soc.getPoblacion() + soc.getCp() + soc.getProvincia() +
		// soc.getPais() + soc.getEdad() + soc.getFechaalta() + soc.getCuota());
	}

	// Metodo para consultar la id para usarla despues al insertar y sumar +1
	public int consultaId(String nDataBase) {

		String sql = "select cod_soc from socio";

		try (Connection conn = this.connect(nDataBase);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			rs.last();
			return rs.getInt("cod_soc");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Volviendo a menu");
			m.menu();
		}
		return 0;

	}

	// Metodo para insertar un nuevo socio
	public void insertarSocio(String nDataBase) {
		System.out.println();
		String sql = "INSERT INTO SOCIO (cod_soc, nombre, apellidos, direccion, telefono, poblacion, cp, provincia, pais, edad, fechaalta, cuota) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(nDataBase);

				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, soc.getCod_soc() + 1);
			pstmt.setString(2, soc.getNombre());
			pstmt.setString(3, soc.getApellidos());
			pstmt.setString(4, soc.getDireccion());
			pstmt.setString(5, soc.getTelefono());
			pstmt.setString(6, soc.getPoblacion());
			pstmt.setString(7, soc.getCp());
			pstmt.setString(8, soc.getProvincia());
			pstmt.setString(9, soc.getPais());
			pstmt.setInt(10, soc.getEdad());
			pstmt.setString(11, soc.getFechaalta());
			pstmt.setInt(12, soc.getCuota());
			pstmt.executeUpdate();
			System.out.println("Insertado en la tabla con exito!");
			System.out.println("Volviendo al menu....");
			m.menu();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Volviendo a menu");
			m.menu();
		}
	}
	
	// Metodo para consultar el codigo para cambiar la cuota
	public void consultaCodigo(String nDataBase) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Dime el codigo del empleado que quieres cambiar la cuota");
		
		// Te comentado otras opciones porque no entendi si querias que buscara por cod o nombre....
		//String n = lector.nextLine();
		int n = lector.nextInt();
		//String sql = "select cod_soc, nombre, apellidos, cuota from socio where nombre = " +'"'+ n +'"';
		String sql = "select cod_soc, nombre, apellidos, cuota from socio where cod_soc = " + n;
		try (Connection conn = this.connect(nDataBase);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			rs.next();
			System.out.println(rs.getInt("cod_soc") + "\t" +
					rs.getString("nombre") + "\t" +
					rs.getString("apellidos") + "\t" +
					rs.getInt("cuota"));
			soc.setCod_soc(rs.getInt("cod_soc"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Volviendo a menu");
			m.menu();
		}
	}

	// Metodo para modificar la cuota
	public void modificarCuota(String nDataBase) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Dime la nueva cuota que quieres poner.");
		int dCuota = lector.nextInt();
		String sql = "UPDATE socio SET cuota = " + dCuota + " where cod_soc = " + soc.getCod_soc();
		
		try (Connection conn = this.connect(nDataBase);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.executeUpdate(sql);
			System.out.println("Modificacion echa con exito");
			System.out.println("Volviendo a menu");
			m.menu();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Volviendo a menu");
			m.menu();
		}
	}
	
	// Metodo para ver el socio antes de borrarlo
	public void verSocio(String nDataBase) {
		String sql = "select cod_soc, nombre, apellidos, direccion, telefono, poblacion, cp, provincia, pais, edad, fechaalta, cuota from socio where cod_soc = " + soc.getCod_soc();
		
		try (Connection conn = this.connect(nDataBase);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			rs.next();
			System.out.println(rs.getInt("cod_soc") + "\t" + 
					rs.getString("nombre") + "\t" +
					rs.getString("apellidos") + "\t" +
					rs.getString("direccion") + "\t" +
					rs.getString("telefono") + "\t" +
					rs.getString("poblacion") + "\t" +
					rs.getString("cp") + "\t" +
					rs.getString("provincia") + "\t" +
					rs.getString("pais") + "\t" +
					rs.getInt("edad") + "\t" +
					rs.getString("fechaalta") + "\t" +
					rs.getInt("cuota"));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Volviendo a menu");
			m.menu();
		}
	}

	// Metodo borrar socio
	public void borrarSocio(String nDataBase) {
		String sql = "delete from socio where cod_soc = " + soc.getCod_soc();
		
		try (Connection conn = this.connect(nDataBase);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.execute(sql);
			System.out.println("Socio eliminado con exito!");
			System.out.println("Volviendo a menu");
			m.menu();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Volviendo a menu");
			m.menu();
		}

	}

	// Menu
	public void menu() {
		Scanner lector = new Scanner(System.in);
		String nDataBase = "bd_videoclub";

		// Menu
		System.out.println("-------------- MENU -------------");
		System.out.println("1- Insertar socio");
		System.out.println("2- Modificar cuota");
		System.out.println("3- Borrar socio");
		System.out.println("4- Salir");
		boolean comprobacion = true;
		int opcion = 0;

		// Compruebo la opcion
		while (comprobacion) {

			if (lector.hasNextInt()) {
				opcion = lector.nextInt();
				if (opcion > 0 && opcion < 5) {
					comprobacion = false;
				} else {
					System.out.println("El numero introducido no coincide con ninguna opcion del menu");
				}
			} else {
				System.out.println("No es un numero entero");
				lector.next();
			}
		}

		switch (opcion) {
		// Insertar socio
		case 1:
			// Metodo para recoger los datos
			m.recogerDatos();
			soc.setCod_soc(m.consultaId(nDataBase)); // Hago un metodo para hacer una consulta del numero mas grande en la cod_soc a si poner el id siguiente a ese
			//m.consultaId(nDataBase); // Prueba
			m.insertarSocio(nDataBase); // Inserto el socio en la tabla
			break;
		case 2:
			// Consulto el socio que quiere modificar a traves del codigo, tengo comentado tambien a traves del nombre
			m.consultaCodigo(nDataBase);
			System.out.println();
			System.out.println("Quieres cambiar la cuota al socio? Si - No");
			lector.nextLine();
			String respuesta = lector.nextLine();
			if(respuesta.equalsIgnoreCase("si")) {
				// En este metodo modifico la cuota que solicito al usuario
				m.modificarCuota(nDataBase);
			}else {
				System.out.println("Volviendo a menu...");
				m.menu();
			}
			
			break;
		case 3:
			System.out.println("Dime el codigo del socio que quieres borrar");
			// Solicito el codigo para buscar al socio a eliminar
			soc.setCod_soc(lector.nextInt());
			// Muestro la informacion del socio que se va a eliminar a continuacion sin pedir confirmacion.
			m.verSocio(nDataBase);
			// Metodo para borrar al socio
			m.borrarSocio(nDataBase);
			break;
		case 4:
			break;
		}

	}
}
