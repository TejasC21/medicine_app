package com.medicine.app.services;

import java.util.List;
import java.util.Map;

import com.medicine.app.entities.UserAddress;

public interface AddressServices {
	
	public UserAddress addUserAddress(UserAddress address);
	public UserAddress getAddressById(Long id);
	public List<UserAddress> getAllAddresses();
	public Map<String, Object> updateAddressDetails(Long id, UserAddress address);
	public UserAddress deleteAddressById(Long id);
}
