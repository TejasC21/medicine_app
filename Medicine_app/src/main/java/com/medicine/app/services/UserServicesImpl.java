package com.medicine.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.app.dtos.CredentialDto;
import com.medicine.app.dtos.UserDto;
import com.medicine.app.entities.User;
import com.medicine.app.exceptions.ResourceNotFoundException;
import com.medicine.app.exceptions.UserAlreadyExistsException;
import com.medicine.app.repositories.UserRepository;

@Service
@Transactional
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder enc;
	
	@Override
	public User addUser(User user) {
		//check if user already exists
		if(userRepo.existsByEmail(user.getEmail())) 
			throw new UserAlreadyExistsException("User Email Already Exists!!!");
		//encrypt the password
		user.setPassword(enc.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	@Override
	public User findUserById(Long userId) {
		User user = userRepo.findById(userId) 
				.orElseThrow(() -> new ResourceNotFoundException("User Id not found!!!"));
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userRepo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Email Id not exists!!!"));
		return user;
	}

	@Override
	public User deleteUser(Long id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User Id not found!!!"));
		userRepo.delete(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public Map<String, Object> editUser(Long userId, UserDto updatedUser) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Id not found!!!"));
		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());
		user.setAge(updatedUser.getAge());
		user.setContactNumber(updatedUser.getContactNumber());
		user.setEmail(updatedUser.getEmail());
		user.setPassword(enc.encode(updatedUser.getPassword()));
		user = userRepo.save(user);
		return Collections.singletonMap("User updated successfully", user.getId());
	}

	@Override
	public User findUserByEmailAndPassword(CredentialDto cred) {
		User user = userRepo.findByEmail(cred.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("Email Id not exists!!!"));
		String rawPass = cred.getPassword();
		if(enc.matches(rawPass, user.getPassword())) {
			return user;
		}
		return null;
	}

}
