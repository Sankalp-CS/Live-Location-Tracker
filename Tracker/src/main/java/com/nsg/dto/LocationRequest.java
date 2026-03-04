package com.nsg.dto;

public class LocationRequest {
	private Long userId;
	private Double latitude;
	private Double longitude;
	private String floor;
	public Long getUserId() {
		return userId;
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
	public void setUserid(Long userId) {
		this.userId = userId;
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
	
	
	
	
	
	
		
}
