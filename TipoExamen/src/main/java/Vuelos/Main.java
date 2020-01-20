package Vuelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	static Session s;
	static Transaction t;
	private static SessionFactory session = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		Vuelo vuelo = new Vuelo("1", "Barcelona", "Madrid", "Comercial", new Date(), new HashSet(), new HashSet());

		s = session.openSession();
		// insertarVuelo(vuelo);
		mostrarVuelos();
		s.close();
	}

	public static void insertarVuelo(Vuelo vuelo) {
		try {
			t = s.beginTransaction();
			s.save(vuelo);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public static void mostrarVuelos() {
		ArrayList<Object[]> lista = new ArrayList<Object[]>(
				s.createSQLQuery("select * from vuelo where IDENTIFICADOR like 2").list());
		if (lista.size() > 0) {
			for (Object[] ob : lista) {
				String cadena = "";
				for (int i = 0; i < ob.length; i++) {
					cadena = cadena.concat(ob[i] + " ");
				}
				System.out.println(cadena);
			}
		} else {
			System.out.println("No hay resultados");
		}

	}

	public static void listarComandante() {
		ArrayList<Object[]> lista = new ArrayList<Object[]>(
				s.createSQLQuery("select * from vuelo where tripulacion like 'comandante'").list());
		if (lista.size() > 0) {
			for (Object[] ob : lista) {
				String cadena = "";
				for (int i = 0; i < ob.length; i++) {
					cadena = cadena.concat(ob[i] + " ");
				}
				System.out.println(cadena);
			}
		} else {
			System.out.println("No hay resultados");
		}
	}

	public static void crearProcedure() {

	}

}
