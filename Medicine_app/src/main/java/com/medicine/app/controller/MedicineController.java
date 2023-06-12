package com.medicine.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.app.dtos.MedicineDto;
import com.medicine.app.entities.Medicine;
import com.medicine.app.services.MedicineServices;

@RestController
public class MedicineController {
	
	@Autowired
	private MedicineServices medicineServices;
	
	@PostMapping("/add")
	public ResponseEntity<?> addMedicine(@RequestBody @Valid Medicine medicine) {
		return ResponseEntity.status(HttpStatus.CREATED).body(medicineServices.addMedicine(medicine));
	}
	
	@GetMapping("/medicine/{id}")
	public ResponseEntity<?> displayMedicineById(@PathVariable("id") Long medicineId) {
		Medicine medicine = medicineServices.getMedicineById(medicineId);
		return ResponseEntity.ok(medicine);
	}
	
	@GetMapping("/medicines")
	public ResponseEntity<?> displayAllMedicines() {
		return ResponseEntity.ok(medicineServices.getAllMedicines());
	}
	
	@PostMapping("/medicine/update/{id}")
	public ResponseEntity<?> updateMedicineDetails(@RequestBody @Valid MedicineDto medicine, @PathVariable("id") Long medicineId) {
		Map<String, Object> result = medicineServices.updateMedicineDetails(medicineId, medicine);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/medicine/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long medicineId) {
		Medicine medicine = medicineServices.deleteMedicineById(medicineId);
		return ResponseEntity.status(HttpStatus.OK).body(medicine);
	}
}
