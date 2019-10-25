package gameforhonor;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createNewTable(String fileName) {
		// SQLite connection string
		String url = "jdbc:sqlite:" + fileName;

		// SQL statement for creating a new table
		String sqlFaccion = "CREATE TABLE IF NOT EXISTS Faccion (\n" 
				+ "    faccion_id integer PRIMARY KEY,\n"
				+ "    nombre_faccion text NOT NULL,\n"
				+ "    lore text NOT NULL\n" 
				+ ");";

		String sqlPersonaje = "CREATE TABLE IF NOT EXISTS Persona (\n" 
				+ "    personaje_id integer PRIMARY KEY,\n"
				+ "    nombre_personaje text NOT NULL,\n"
				+ "    ataque integer NOT NULL,\n"
				+ "    defensa integer NOT NULL,\n"
				+ "	   faccion_id integer,\n"
				+ "    FOREIGN KEY(faccion_id) REFERENCES Faccion(faccion_id)" 
				+");";
		
		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sqlFaccion);
			stmt.execute(sqlPersonaje);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		String nDataBase = "forhonor.db";
		createNewDatabase(nDataBase);
		createNewTable(nDataBase);
	}
}