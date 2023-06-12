package com.medicine.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.app.entities.Medicine;
import com.medicine.app.entities.UserAddress;
import com.medicine.app.exceptions.ResourceNotFoundException;
import com.medicine.app.exceptions.UserAddressAlreadyExistsException;
import com.medicine.app.exceptions.UserAlreadyExistsException;
import com.medicine.app.repositories.UserAddressRepository;

@Service
@Transactional
public class AddressServicesImpl implements AddressServices {
	
	@Autowired
	private UserAddressRepository addressRepo;
	
	@Override
	public UserAddress addUserAddress(UserAddress address) {
		//check if user already exists
		if(addressRepo.existsByCity(address.getCity()))
			throw new UserAddressAlreadyExistsException("Address Already Exists!!!");
		return addressRepo.save(address);
	}

	@Override
	public UserAddress getAddressById(Long id) {
		UserAddress address = addressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address not found!!!"));
		return address;
	}

	@Override
	public List<UserAddress> getAllAddresses() {
		List<UserAddress> addresses = addressRepo.findAll();
		return addresses;
	}

	@Override
	public Map<String, Object> updateAddressDetails(Long id, UserAddress addr) {
		UserAddress address = addressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address not found!!!"));
		address.setCity(addr.getCity());
		address.setState(addr.getState());
		address.setPincode(addr.getPincode());
		
		address = addressRepo.save(address);
		return Collections.singletonMap("Address details updated successfully", address.getId());
		
	}

	@Override
	public UserAddress deleteAddressById(Long id) {
		UserAddress address = addressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address not found!!!"));
		addressRepo.delete(address);
		return address;
	}
	
	
}
