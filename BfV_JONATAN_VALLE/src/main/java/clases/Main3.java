package clases;

import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main3 {
	
	static Session s;
	static Transaction t;
	private static SessionFactory session = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		Weapon w = new Weapon();
		
		WeaponId weapon = new WeaponId(10, "KE7", "Light Machine Gun", 23, 65);
		
		w.setId(weapon);
		
		s = session.openSession();
		insertWeapon(w);
		s.close();
	}

	
	public static void insertWeapon(Weapon weapon) {
		try {
			t = s.beginTransaction();
			s.save(weapon);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
	}
}
