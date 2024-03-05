package com.kodnest.tunehub.service;

import com.kodnest.tunehub.entity.User;

public interface TuneHubService {
	 public String addUser( User user);
	 
	 public boolean emailExists(String email);
	 
	 public boolean validateUser(String email, String password);
	 
	 public String getRole(String email);
}