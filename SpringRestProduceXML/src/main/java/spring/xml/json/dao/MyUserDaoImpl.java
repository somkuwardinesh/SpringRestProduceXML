package spring.xml.json.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import spring.xml.json.model.MyUser;


public class MyUserDaoImpl implements MyUserDao {

	@Autowired
	SessionFactory sessionFactory;

	public void saveMyUser(MyUser myUser) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (myUser != null) {
			try {
				session.save(myUser);
				t.commit();
				session.close();
			} catch (Exception e) {
				t.rollback();
				session.close();
			}
		}
	}

	public void updateMyUser(MyUser myUser) {

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (myUser != null) {
			try {
				session.update(myUser);
				t.commit();
				session.close();
			} catch (Exception e) {
				t.rollback();
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<MyUser> getMyUserList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(MyUser.class);
		return (List<MyUser>) criteria.list();
	}

	public MyUser findByID(long id) {
		Session session = sessionFactory.openSession();
		MyUser myUser = new MyUser();
		try {
			myUser = (MyUser) session.get(MyUser.class, id);
			session.close();
		} catch (Exception e) {
			session.close();
		}
		return myUser;
	}

	public MyUser findByName(String name) {

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		MyUser myUser = new MyUser();
		try {
			Query query = session.createQuery("from MyUser where name = ?");
			query.setParameter(0, name);
			myUser = (MyUser) query.uniqueResult();
			t.commit();
			session.close();
		} catch (Exception e) {
			t.rollback();
			session.close();
		}

		return myUser;
	}

	public void deleteMyUserById(long id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		MyUser myUser = new MyUser();
		try {
			myUser = (MyUser) session.get(MyUser.class, id);
			session.delete(myUser);
			t.commit();
			session.close();
		} catch (Exception e) {
			t.rollback();
			session.close();
		}

	}


}
