package com.app.service.impl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IUserDao dao;
	

	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=dao.findByUserEmail(username);
		Set<GrantedAuthority> grantedAuthoritis=new HashSet<>();
		for(String role:user.getRoles()) {
			grantedAuthoritis.add(new SimpleGrantedAuthority(role));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), grantedAuthoritis);
	}

}
