package com.medicine.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
	
	private String firstName;
	private String lastName;
	private int age;
	private String contactNumber;
	private String email;
	private String password;
}
