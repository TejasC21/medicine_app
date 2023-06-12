package com.medicine.app.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.app.dtos.MedicineDto;
import com.medicine.app.entities.Medicine;

public interface MedicineServices {
	
	public Medicine addMedicine(Medicine medicine);
	public Medicine getMedicineById(Long id);
	public List<Medicine> getAllMedicines();
	public Map<String, Object> updateMedicineDetails(Long id, MedicineDto dto);
	public Medicine deleteMedicineById(Long id);
}
