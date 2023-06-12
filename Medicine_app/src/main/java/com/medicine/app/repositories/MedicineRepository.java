package com.medicine.app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.app.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
		
	boolean existsByName(String name);
}
