package com.medicine.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.app.entities.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
	
	boolean existsByCity(String city);
}
