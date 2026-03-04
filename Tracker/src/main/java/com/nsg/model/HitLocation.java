package com.nsg.model;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class HitLocation{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private User user;
	
	
	
	@Column(nullable=false)
	private Double latitude;
	
	@Column(nullable=false)
	private Double longitude;
	
	@Column(nullable=false)
	private String floor;
	
	@Column(nullable=false)
	private LocalDateTime timestamp;
	
	@PrePersist
	public void prePersist()
	{
		this.timestamp=LocalDateTime.now();
	}

	public HitLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HitLocation(Long id, User user, Double latitude, Double longitude, String floor, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.latitude = latitude;
		this.longitude = longitude;
		this.floor = floor;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getFloor() {
		return floor;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}