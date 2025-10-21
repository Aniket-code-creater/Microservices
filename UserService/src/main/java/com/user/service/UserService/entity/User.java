package com.user.service.UserService.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="micro_user")
@Entity
public class User {

	@Id
	@Column(name= "ID")
	private String userId;
	
	@Column(name="Name", length = 20)
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="about")
	private String about;
	
	@Transient
	private List<Rating> ratings;
	
	
}
