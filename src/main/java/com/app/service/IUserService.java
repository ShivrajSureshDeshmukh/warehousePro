package com.app.service;

import com.app.model.User;

public interface IUserService {
	
	public Integer saveUser(User user);
	public User findByUserEmail(String useremail);

}
