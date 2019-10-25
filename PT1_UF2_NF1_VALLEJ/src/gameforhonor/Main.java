package gameforhonor;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

		String sqlPersonaje = "CREATE TABLE IF NOT EXISTS Personaje (\n" 
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
	
	/*public void selectTablas(String nDataBase){
        String sql = "select * from sqlite_master where type = 'table'";
        
        try (Connection conn = this.connect(nDataBase);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
	 private Connection connect(String nDataBase) {
	        // SQLite connection string
	        String url = "jdbc:sqlite:C:" + nDataBase;
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	
	public void insertFaccion( String nombre_faccion, String lore, String nDataBase ) {
        String sql = "INSERT INTO Faccion(nombre_faccion, lore) VALUES(?,?)";

        try (Connection conn = this.connect(nDataBase);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre_faccion);
            pstmt.setString(2, lore);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	 public void selectFaccion(String nDataBase){
		 System.out.println();
		 System.out.println("Mostrando las facciones");
		 System.out.println("faccion_id\t" + "nombre_faccion\t" + "lore");
	        String sql = "SELECT faccion_id, nombre_faccion, lore FROM Faccion";
	        
	        try (Connection conn = this.connect(nDataBase);
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(rs.getInt("faccion_id") +  "\t" + 
	                                   rs.getString("nombre_faccion") + "\t" +
	                                   rs.getString("lore"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 
	 public void insertGuerreros( String nombre_personaje, int ataque, int defensa, int faccion_id, String nDataBase ) {
	        String sql = "INSERT INTO Personaje(nombre_personaje, ataque, defensa, faccion_id) VALUES(?,?,?,?)";
	 
	        try (Connection conn = this.connect(nDataBase);
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, nombre_personaje);
	            pstmt.setInt(2, ataque);
	            pstmt.setInt(3, defensa);
	            pstmt.setInt(4, faccion_id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	 
	 public void selectGuerreros(String nDataBase){
		 System.out.println();
		 System.out.println("Mostrando todos los guerreros");
		 System.out.println("id\t" + "personaje\t" + "ataque\t" + "defensa\t" + "faccion_id");
	        String sql = "SELECT personaje_id, nombre_personaje, ataque, defensa, faccion_id FROM Personaje";
	        
	        try (Connection conn = this.connect(nDataBase);
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(rs.getInt("personaje_id") +  "\t" + 
	                                   rs.getString("nombre_personaje") + "\t" +
	                                   rs.getInt("ataque") + "\t" +
	                                   rs.getInt("defensa") + "\t" +
	                                   rs.getInt("faccion_id"));
	            }
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	 
	 public void selectCaballeros(String nDataBase){
		 System.out.println();
		 System.out.println("Mostrando solo la faccion de caballeros");
		 System.out.println("id\t" + "personaje\t" + "ataque\t" + "defensa\t" + "faccion_id");
	        String sql = "SELECT personaje_id, nombre_personaje, ataque, defensa, faccion_id FROM Personaje WHERE faccion_id = 1";
	        
	        try (Connection conn = this.connect(nDataBase);
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(rs.getInt("personaje_id") +  "\t" + 
	                                   rs.getString("nombre_personaje") + "\t" +
	                                   rs.getInt("ataque") + "\t" +
	                                   rs.getInt("defensa") + "\t" +
	                                   rs.getInt("faccion_id"));
	            }
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	 
	 public void selectSamurais(String nDataBase){
		 System.out.println();
		 System.out.println("MOSTRANDO SAMURAIS POR ORDEN DE ATAQUE MAYOR");
		 System.out.println("id\t" + "personaje\t" + "ataque\t" + "defensa\t" + "faccion_id");
	        String sql = "SELECT personaje_id, nombre_personaje, ataque, defensa, faccion_id FROM Personaje WHERE faccion_id = 3 order by ataque DESC";
	        
	        try (Connection conn = this.connect(nDataBase);
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(rs.getInt("personaje_id") +  "\t" + 
	                                   rs.getString("nombre_personaje") + "\t" +
	                                   rs.getInt("ataque") + "\t" +
	                                   rs.getInt("defensa") + "\t" +
	                                   rs.getInt("faccion_id"));
	            }
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }

	public static void main(String[] args) {
		String nDataBase = "forhonor.db";
		createNewDatabase(nDataBase);
		createNewTable(nDataBase);
		Main app = new Main();
		//app.selectTablas(nDataBase);
		
		// Inserto Facciones
		app.insertFaccion("Caballeros", "Los Caballeros de for honor eran soldados honrados con su armadura de acero.", nDataBase);
		app.insertFaccion("Vikingos", "Los Vikingos eran unos enemigos con apenas armadura pero una gran fuerza bruta", nDataBase);
		app.insertFaccion("Samurais", "Los Samurais eran los mas astutos agiles y eficaces", nDataBase);
		// Muestro Facciones
		app.selectFaccion(nDataBase);
		
		// Inserto Guerreros
		app.insertGuerreros("El Conquistador", 200, 200, 1, nDataBase);
		app.insertGuerreros("Guardian", 100, 300, 1, nDataBase);
		app.insertGuerreros("Pacificadora", 500, 100, 1, nDataBase);
		app.insertGuerreros("Berserker", 600, 200, 2, nDataBase);
		app.insertGuerreros("Valquiria", 400, 400, 2, nDataBase);
		app.insertGuerreros("Nobushi\t", 450, 350, 3, nDataBase);
		app.insertGuerreros("Orichi\t", 800, 150, 3, nDataBase);
		
		//Muestro guerreros
		app.selectGuerreros(nDataBase);
		
		//Muestro Caballeros
		app.selectCaballeros(nDataBase);
		
		//Muestro Samurais ordenados por ataque mayor
		app.selectSamurais(nDataBase);
		
	}
}