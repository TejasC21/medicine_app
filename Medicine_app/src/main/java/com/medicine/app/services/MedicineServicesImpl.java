package com.medicine.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.app.dtos.MedicineDto;
import com.medicine.app.entities.Medicine;
import com.medicine.app.exceptions.ResourceNotFoundException;
import com.medicine.app.exceptions.UserAlreadyExistsException;
import com.medicine.app.repositories.MedicineRepository;

@Service
@Transactional
public class MedicineServicesImpl implements MedicineServices {
	
	@Autowired
	private MedicineRepository medicineRepo;
	
	@Override
	public Medicine addMedicine(Medicine medicine) {
		//check if user already exists
		if(medicineRepo.existsByName(medicine.getName()))
			throw new UserAlreadyExistsException("Medicine Already Exists!!!");
		return medicineRepo.save(medicine);
		
	}

	@Override
	public Medicine getMedicineById(Long id) {
		Medicine medicine = medicineRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found!!!"));
		return medicine;
	}

	@Override
	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = medicineRepo.findAll();
		return medicines;
	}

	@Override
	public Map<String, Object> updateMedicineDetails(Long id, MedicineDto dto) {
		Medicine medicine = medicineRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found!!!"));
		medicine.setName(dto.getName());
		medicine.setTime(dto.getTime());
		medicine = medicineRepo.save(medicine);
		return Collections.singletonMap("Medicine details updated successfully", medicine.getId());
	}

	@Override
	public Medicine deleteMedicineById(Long id) {
		Medicine medicine = medicineRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found!!!"));
		medicineRepo.delete(medicine);
		return medicine;
	}

}
