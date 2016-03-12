package org.crce.interns.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager manager;
	
	//@Autowired
	//private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("In UserDaoImpl....");
		manager.persist(user);
		//sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<User> viewUser() {
		// TODO Auto-generated method stub
		List<User> users = manager.createQuery("Select a From User a", User.class).getResultList();
		return users;
	}

	@Override
	public User getUser(String name) {
		List<User> l = manager.createQuery("SELECT u FROM User u WHERE u.name like :userName", User.class).setParameter("userName", name).getResultList();
		if (l.size() > 0) {
			System.out.println(l.get(0).getName());
			return l.get(0);
		}
		return null;
	}
}
