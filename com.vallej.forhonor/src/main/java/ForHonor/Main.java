package ForHonor;

import java.math.BigInteger;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
	
	static Session s;
	static Transaction t;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SessionFactory session = HibernateUtil.getSessionFactory();
		s = session.openSession();
		listarPersonajes();
		//modificarAtaque("100", "1");
		//borrarPersonajeId("1");
		s.close();
	}
	
	public static void listarPersonajes() {
		ArrayList<Object[]> lista = new ArrayList<Object[]>(s.createSQLQuery("SELECT * FROM personaje").list());
		System.out.println("ID  NOMBRE  AT  DF  Faccion");
		for(Object[] ob : lista) {
			String cadena = "";
			for(int i = 0; i < ob.length; i++) {
				cadena = cadena.concat(ob[i]+ " ");
			}
			System.out.println(cadena);
		}
	}
	
	public static void modificarAtaque(String newATK, String id) {
		t = s.beginTransaction();
		String hqlUpdate = "UPDATE Personaje p SET p.ataque = :newATK WHERE p.personajeId = :id";
		int updateEntities = s.createQuery(hqlUpdate).setString("newATK", newATK).setString("id", id).executeUpdate();
		t.commit();
	}
	
	public static void borrarPersonajeId(String id) {
		t = s.beginTransaction();
		String hqlDelete = "DELETE FROM Personaje p WHERE p.personajeId = :id";
		int deleteRegister = s.createQuery(hqlDelete).setString("id", id).executeUpdate();
		t.commit();
	}
	
	public static void borrarPersonaje(Personaje p) {
		try {
			t = s.beginTransaction();
			s.delete(p);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
	}
	
	public static void eliminarFaccion(Faccion a) {
		String hqlQuery = "select count(*) from Faccion f, Personaje p where f.faccion_id = p.faccion_id and f.faccion_id = "
				+ a.getFaccionId();
		BigInteger bi = (BigInteger) (s.createSQLQuery(hqlQuery).list().get(0));
		if (bi == BigInteger.ZERO) {
			try {
				t = s.beginTransaction();
				s.delete(a);
				t.commit();
			} catch (Exception e) {
				e.printStackTrace();
				t.rollback();
			}
		} else {
			System.out.println("Esta faccion tiene personajes asociados");
		}	
	}
}
