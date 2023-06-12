package com.medicine.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.app.entities.UserAddress;
import com.medicine.app.services.AddressServices;

@RestController
public class UserAddressController {
	
	@Autowired
	private AddressServices addressServices;
	
	@PostMapping("/address/add")
	public ResponseEntity<?> addAddress(@RequestBody UserAddress address) {
		return ResponseEntity.status(HttpStatus.CREATED).body(addressServices.addUserAddress(address));
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<?> displayAddressById(@PathVariable("id") Long addressId) {
		UserAddress address = addressServices.getAddressById(addressId);
		return ResponseEntity.ok(address);
	}
	
	@GetMapping("/addresses")
	public ResponseEntity<?> displayAllAddresses() {
		return ResponseEntity.ok(addressServices.getAllAddresses());
	}
	
	@PostMapping("/address/update/{id}")
	public ResponseEntity<?> updateAddressDetails(@RequestBody @Valid UserAddress address, @PathVariable("id") Long addressId) {
		Map<String, Object> result = addressServices.updateAddressDetails(addressId, address);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/address/delete/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable("id") Long addressId) {
		UserAddress address = addressServices.deleteAddressById(addressId);
		return ResponseEntity.status(HttpStatus.OK).body(address);
	}
}
