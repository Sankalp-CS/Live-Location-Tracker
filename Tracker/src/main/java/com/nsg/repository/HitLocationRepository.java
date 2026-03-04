package com.nsg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nsg.model.HitLocation;
@Repository
public interface HitLocationRepository extends JpaRepository<HitLocation,Long>{
	
	//latest location of one user
HitLocation findTopByUser_IdOrderByTimestampDesc(Long userId);

	//full history of one user
List<HitLocation> findByUser_IdOrderByTimestampDesc(Long userId);

	//get latest loc. of all user
@Query("""
SELECT h FROM HitLocation h
JOIN FETCH h.user
WHERE h.timestamp =
(
    SELECT MAX(h2.timestamp)
    FROM HitLocation h2
    WHERE h2.user = h.user
)
""")
List<HitLocation> findLatestLocationsOfAllUsers();
}
