package com.medicine.app.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class MedicineDto {
	
	private String name;
	private String time;
}
