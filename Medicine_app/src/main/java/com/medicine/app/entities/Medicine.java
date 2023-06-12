package com.medicine.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "medicine_tbl")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Medicine extends BaseEntity {
	
	@Column(name = "medicine_name")
	private String name;
	
	@Column(nullable = false)
	private String time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
