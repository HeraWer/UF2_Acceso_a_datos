package clases;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2 {

	static Session s;
	static Transaction t;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory session = HibernateUtil.getSessionFactory();
		s = session.openSession();
		listarJugadores();
		s.close();

	}
	
	public static void listarJugadores() {
		ArrayList<Object[]> lista = new ArrayList<Object[]>(s.createSQLQuery("SELECT user_id, kills, Deads FROM bfplayer").list());
		System.out.println("Nombre - Kills - Deads");
		for(Object[] ob : lista) {
			String cadena = "";
			for(int i = 0; i < ob.length; i++) {
				cadena = cadena.concat(ob[i]+ " ");
			}
			System.out.println(cadena);
		}
	}

}
