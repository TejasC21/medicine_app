package com.medicine.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.app.dtos.CredentialDto;
import com.medicine.app.dtos.UserDto;
import com.medicine.app.entities.User;
import com.medicine.app.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid User user) {
		// invoke service layer method , for saving : user info
		return ResponseEntity.status(HttpStatus.CREATED).body(userServices.addUser(user));
	}
	
	@GetMapping("/signin")
	public ResponseEntity<?> userLogin(@RequestBody CredentialDto cred) {
		User user = userServices.findUserByEmailAndPassword(cred);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> displayUserById(@PathVariable("id") Long userId) {
		User user = userServices.findUserById(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> displayAllUsers() {
		return ResponseEntity.ok(userServices.getAllUsers());
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> editUser(@RequestBody @Valid UserDto user, @PathVariable("id") Long userId) {
		Map<String, Object> result = userServices.editUser(userId, user);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
		User user = userServices.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
}
