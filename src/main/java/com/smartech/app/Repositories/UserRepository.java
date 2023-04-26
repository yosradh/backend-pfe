package com.smartech.app.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartech.app.Entities.Utilisateurs;

@Repository
public interface UserRepository extends JpaRepository<Utilisateurs,Long> {

	Utilisateurs findByEmail(String email);
	
	Boolean existsByUsername(String username);
	
	Optional<Utilisateurs> findByEmailAndPassword(String email, String password);
	 
	List<Utilisateurs> findByRole(String role);	
	
	

}
