package com.nsg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsg.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//Optional<User> get
}
