package org.crce.interns.service;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserBean;
import org.crce.interns.dao.UserDao;
import org.crce.interns.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		User user = new User();
		BeanUtils.copyProperties(userBean, user);
		System.out.println("In UserServiceImpl ....");
		userDao.addUser(user);
	}

	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return userDao.viewUser();
	}

	@Override
	public UserBean getUser(String name) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		User user = userDao.getUser(name);
		if (user != null)
			BeanUtils.copyProperties(user, userBean);
		return userBean;
	}
	
}
