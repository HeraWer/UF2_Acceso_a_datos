package clases;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Main5 {
	
	static Session s;
	static Transaction t;
	private static SessionFactory session = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		updatePersonajeFaccion();
		
	}
	
	public static void updatePersonajeFaccion() {
		StoredProcedureQuery query = s
			    .createStoredProcedureQuery("borrar_personajes");

		query.execute();
		s.refresh(null);
	}

}
