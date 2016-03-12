package org.crce.interns.service;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserBean;
import org.crce.interns.model.User;

public interface UserService {
	
	public void addUser(UserBean userBean);
	
	public List<User> viewUsers();
	
	public UserBean getUser(String name);
}
