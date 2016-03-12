package org.crce.interns.dao;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.model.User;

public interface UserDao {

	public void addUser(User user);
	
	public List<User> viewUser();
	
	public User getUser(String name);
}
