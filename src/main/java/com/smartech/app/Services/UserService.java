package com.smartech.app.Services;

import java.util.List;
import java.util.Optional;
import com.smartech.app.Entities.Utilisateurs;

public interface UserService {
	    Utilisateurs saveUser(Utilisateurs Utilisateurs);
	    List<Utilisateurs> getAllUtilisateurs();
	    Utilisateurs getUtilisateursById(Long Id);
	    Utilisateurs updateUtilisateurs(Utilisateurs Utilisateurs,long id);
	    void deleteUtilisateurs(long id);
	    
	    Utilisateurs findByEmail(String email);
						
		List<Utilisateurs> getUtilisateursByRole(String role);
		
		Optional<Utilisateurs> findByEmailAndPassword(String email, String password);
		

}
