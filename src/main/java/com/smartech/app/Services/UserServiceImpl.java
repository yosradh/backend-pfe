package com.smartech.app.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.smartech.app.Entities.Utilisateurs;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 
	private UserRepository UserRepository;
	@Autowired
	
    public UserServiceImpl(UserRepository UserRepository,PasswordEncoder passwordEncoder) {
        super();
        this.UserRepository = UserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Utilisateurs saveUser(Utilisateurs Utilisateurs) {
        return UserRepository.save(Utilisateurs);
    }

    @Override
    public List<Utilisateurs> getAllUtilisateurs() {
        return UserRepository.findAll();
    }

    @Override
    public Utilisateurs getUtilisateursById(Long Id) {
        return UserRepository.findById(Id).orElseThrow(()->
                new NotFoundException("Utilisateur ,Id",Id));
    }

    @Override
    public Utilisateurs updateUtilisateurs(Utilisateurs User, long id) {
    	Utilisateurs UserExist = UserRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("User, Id",id));
        UserExist.setUsername(User.getUsername());
        UserExist.setPassword(User.getPassword());
        UserExist.setEmail(User.getEmail());
        UserExist.setFirstName(User.getFirstName());
        UserExist.setLastName(User.getLastName());
        UserExist.setRole(User.getRole());


        UserRepository.save(UserExist);
        return UserExist;
    }

    @Override
    public void deleteUtilisateurs(long id) {
        UserRepository.findById(id).orElseThrow(()->
                new NotFoundException("User ,Id",id));
        UserRepository.deleteById(id);
    }
    
    @Override
    public Utilisateurs findByEmail(String email) {
        return UserRepository.findByEmail(email);
    }

	@Override
	public List<Utilisateurs> getUtilisateursByRole(String role) {
		 return UserRepository.findByRole(role) ;
				
			}

	
	@Override
	public Optional<Utilisateurs> findByEmailAndPassword(String email, String password){
		return UserRepository.findByEmailAndPassword(email, password);
	}
	
	
}
