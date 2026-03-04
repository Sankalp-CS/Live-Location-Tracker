package com.nsg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true,nullable=false)
	private String username;       //hit1_commander
	
	@Column(nullable=false)
	@JsonIgnore
	private String pw;				//pw encrypted
	
	@Column(nullable=false)
	private String role;			//commander or soldier

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPw() {
		return pw;
	}

	public String getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
