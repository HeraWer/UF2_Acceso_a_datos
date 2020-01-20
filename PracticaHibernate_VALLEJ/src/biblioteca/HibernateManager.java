package biblioteca;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateManager {

	static Session session;
	static Transaction tr;
	static SessionFactory sf =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		/*Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");*/
		return sf;
		
	}
	
	public static void openSession() {
		session = sf.openSession();
	}

	public void crearRegistre(Object a, String id) {
		if (getByID(a.getClass(), id) == null) {
			try {
				tr = session.beginTransaction();
				session.save(a);
				tr.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tr.rollback();
			}
		} else {
			System.out.println("El ID ya esta en uso");
		}
	}

	public void eliminarRegistre(Object a) {
		try {
			tr = session.beginTransaction();
			session.delete(a);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}

	public Object getByID(Class a, String id) {
		try {
			Object result = session.get(a, id);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void printByID(Class a, String id) {
		Object aux = getByID(a, id);
		if (aux != null) {
			System.out.println(aux.toString());
		}
	}

	public void listarTabla(String tabla) {
		ArrayList<Object[]> lista = new ArrayList<Object[]>(session.createSQLQuery("select * from " + tabla).list());
		System.out.println(tabla.toUpperCase() + ":");
		for (Object[] ob : lista) {
			String cadena = "";
			for (int i = 0; i < ob.length; i++) {
				cadena = cadena.concat(ob[i] + " ");
			}
			System.out.println(cadena);
		}
	}

	public void modificar(Object a) {
		tr = session.beginTransaction();
		session.clear();
		session.update(a);
		tr.commit();
	}

	public void close() {
		session.close();
	}
}
