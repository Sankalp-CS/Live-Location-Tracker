package com.nsg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsg.dto.LocationRequest;
import com.nsg.model.HitLocation;
import com.nsg.model.User;
import com.nsg.repository.HitLocationRepository;
import com.nsg.repository.UserRepository;

@Service
public class LocationService {
	
	@Autowired
	private UserRepository userrepo;

    @Autowired
    private HitLocationRepository repository;

    // Save location
    public HitLocation saveLocation(LocationRequest request) {
    	 // fetch existing user from DB
        User user = userrepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        HitLocation location = new HitLocation();
        location.setUser(user);
        location.setFloor(request.getFloor());
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        return repository.save(location);
    }

    // Get latest position of one user
    public HitLocation getLatestByUser(Long userId) {
        return repository.findTopByUser_IdOrderByTimestampDesc(userId);
    }

    // Get full history of one user
    public List<HitLocation> getHistory(Long userId) {
        return repository.findByUser_IdOrderByTimestampDesc(userId);
    }

    // For now, simple version of "all latest"
    public List<HitLocation> getAllLocations() {
        return repository.findLatestLocationsOfAllUsers();
    }
}
