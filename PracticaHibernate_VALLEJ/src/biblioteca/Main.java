package biblioteca;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s = HibernateManager.getSessionFactory().openSession();
	}

}
