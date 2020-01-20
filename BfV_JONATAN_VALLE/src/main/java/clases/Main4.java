package clases;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main4 {

	static Session s;
	static Transaction t;
	private static SessionFactory session = HibernateUtil.getSessionFactory();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bfplayer bfplayer = new Bfplayer("Jonatan", 4, 10, 4, 100, 50);
		
		s = session.openSession();
		//insertarJugador(bfplayer);
		listarJugadores();
		s.close();
		

	}
	
	public static void insertarJugador(Bfplayer bfplayer) {
		try {
			t = s.beginTransaction();
			s.save(bfplayer);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
	}

	public static void listarJugadores() {
		ArrayList<Object[]> lista = new ArrayList<Object[]>(s.createSQLQuery("SELECT * FROM bfplayer WHERE user_id = 'Jonatan'").list());
		System.out.println("");
		for(Object[] ob : lista) {
			String cadena = "";
			for(int i = 0; i < ob.length; i++) {
				cadena = cadena.concat(ob[i]+ " ");
			}
			System.out.println(cadena);
		}
	}
}
