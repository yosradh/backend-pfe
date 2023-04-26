package com.smartech.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smartech.app.Entities.Utilisateurs;
import com.smartech.app.Services.UserService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

//@PersistenceContext
	//private EntityManager entityManager;
	private UserService UserService;

    public AdminController(UserService UserService) {
        super();
        this.UserService = UserService;

    }
	   @PostMapping("/addUser")
	    public ResponseEntity<Utilisateurs> saveUser(@RequestBody Utilisateurs User){
	        return new ResponseEntity<Utilisateurs>(UserService.saveUser(User), HttpStatus.CREATED);
	    }
	   
	    @GetMapping("/showUser")
	    public List<Utilisateurs> getAllUser(){
	        return UserService.getAllUtilisateurs();
	    }
	    @GetMapping("/showUser/{id}")
	    public ResponseEntity<Utilisateurs> getUserById(@PathVariable("id") long Id){
	        return new ResponseEntity<Utilisateurs>(UserService.getUtilisateursById(Id),HttpStatus.OK);
	    }
	    
	    @PutMapping("/updateUser/{id}")
	    public ResponseEntity<Utilisateurs> updateUser(@PathVariable("id") long id,@RequestBody Utilisateurs User){
	        return new ResponseEntity<Utilisateurs>(UserService.updateUtilisateurs(User,id),HttpStatus.OK);
	    }

	    //delete api
	    @DeleteMapping("/deleteUser/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
	        UserService.deleteUtilisateurs(id);
	        return new ResponseEntity<String>("User deleted with success",HttpStatus.OK);
	    }
	    

	    @GetMapping("/showAgent/{role}")
	    public List<Utilisateurs> getUserByRole(@PathVariable("role") String role){
	        return UserService.getUtilisateursByRole(role);
	    }
	    

	    @PostMapping("/login")
	    public ResponseEntity<Utilisateurs> login(@RequestBody Utilisateurs loginRequest) {
	        String email = loginRequest.getEmail();
	        String password = loginRequest.getPassword();

	        Optional<Utilisateurs> optionalUtilisateurs = UserService.findByEmailAndPassword(email, password);

	        if (optionalUtilisateurs.isPresent()) {
	            Utilisateurs utilisateurs = optionalUtilisateurs.get();
	            return ResponseEntity.ok(utilisateurs);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    }


	    
	    @PostMapping("/reset-password")
	    public ResponseEntity<Object> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
	    	Utilisateurs user = UserService.findByEmail(email);
	        if (user == null) {
	            return new ResponseEntity<>("L'utilisateur n'existe pas", HttpStatus.BAD_REQUEST);
	        }

	        user.setPassword(newPassword);
	        UserService.saveUser(user);
	        return new ResponseEntity<>("Le mot de passe a été modifié avec succès", HttpStatus.OK);
	    }
	    
}

