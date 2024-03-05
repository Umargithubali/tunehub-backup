package com.kodnest.tunehub.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.TuneHubRepository;
import com.kodnest.tunehub.service.TuneHubService;
@Service
public class TuneHubServiceImpl implements TuneHubService {
	@Autowired
	TuneHubRepository userRepository;
	public String addUser( User user) {
		userRepository.save(user);
		return "user added successfully";
	}
	//to check the duplicate entries
	public boolean emailExists(String email) {
		if(userRepository.findByEmail(email)!= null) {
			return true;
		}else {
			return false;			
		}
	}
	public boolean validateUser(String email, String password) {
		User user = userRepository.findByEmail(email);

		String out = user.getPassword();
		if(password.equals(out)) {
			return true;
		}else {
			return false;
		}
	}
	public String getRole(String email) {
		User user = userRepository.findByEmail(email);
		return user.getRole();
	}
}