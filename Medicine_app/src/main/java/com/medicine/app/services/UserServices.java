package com.medicine.app.services;

import java.util.List;
import java.util.Map;

import com.medicine.app.dtos.CredentialDto;
import com.medicine.app.dtos.UserDto;
import com.medicine.app.entities.User;
import com.medicine.app.exceptions.ResourceNotFoundException;

public interface UserServices {
	
	public User addUser(User user);
	public User findUserById(Long userId);
	public User findUserByEmail(String email);
	public User deleteUser(Long id);
	public List<User> getAllUsers();
	public Map<String, Object> editUser(Long userId, UserDto dto);
	public User findUserByEmailAndPassword(CredentialDto cred);
}
