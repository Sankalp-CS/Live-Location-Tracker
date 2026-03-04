package com.nsg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsg.dto.LocationRequest;
import com.nsg.model.HitLocation;
import com.nsg.service.LocationService;

@RestController
@RequestMapping("/api/location")
public class LocationController {
		@Autowired
		private LocationService service;
		
		
		
		// Save location from hit device
	    @PostMapping("/update")
	    public HitLocation updateLocation(@RequestBody LocationRequest request) {
	        return service.saveLocation(request);
	    }

	    // Get latest location of one user
	    @GetMapping("/latest/{userId}")
	    public HitLocation getLatest(@PathVariable Long userId) {
	        return service.getLatestByUser(userId);
	    }

	    // Get full history of one user
	    @GetMapping("/history/{userId}")
	    public List<HitLocation> getHistory(@PathVariable Long userId) {
	        return service.getHistory(userId);
	    }
	    
	    //get latest loc. of all-user
	    @GetMapping("/all-latest")
	    public List<HitLocation> getALL()
	    {
	    	return service.getAllLocations();
	    }
}
