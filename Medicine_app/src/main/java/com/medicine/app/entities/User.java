package com.medicine.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_tbl")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
@Getter
@Setter
public class User extends BaseEntity {
	
	@NotBlank(message = "First Name can't be blank")
	@Length(min = 4, max = 25, message = "Invalid first name!!!")
	@Column(name = "fisrt_name", length = 25)
	private String firstName;
	
	@NotBlank(message = "Last Name can't be blank")
	@Column(name = "Last_name", length = 25)
	private String lastName;
	
	private int age;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@Column(length = 25, unique = true)
	@Email(message = "Invalid email format!!!")
	private String email;
	
	@Column(length = 300)
	@JsonProperty(access = Access.WRITE_ONLY) // skipped during ser(=marshalling) n kept during de-ser (un marshalling)
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	private UserAddress address;

	
}
