package com.smartech.app.Controller;
import com.smartech.app.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;
import com.smartech.app.Entities.Affectation;

import java.util.List;
import java.util.Optional;

import com.smartech.app.Services.AffectationService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @PostMapping("/addAff")
    public ResponseEntity<Affectation> createAffectation(@RequestBody Affectation affectation) {
        Affectation savedAffectation = affectationService.createAffectation(affectation);
        return new ResponseEntity<>(savedAffectation, HttpStatus.CREATED);
    }

 // Read - Single
    @GetMapping("/Aff/{id}")
    public ResponseEntity<Affectation> getAffectationById(@PathVariable(value = "id") Long id) {
        Optional<Affectation> affectation = affectationService.getAffectationById(id);
        if (affectation.isPresent()) {
            return new ResponseEntity<>(affectation.get(), HttpStatus.OK);
        } else {
            throw new NotFoundException("Affectation not found with id: " + id);
        }
    }

    
    @GetMapping("/Mission/Aff/{missionId}")
    public List<Affectation> getAllAffectationsByMissionId(@PathVariable Long missionId) {
        return affectationService.getAllAffectationsByMissionId(missionId);
    }

    

    // Read - All
    @GetMapping("/Affectations")
    public ResponseEntity<List<Affectation>> getAllAffectations() {
        List<Affectation> affectations = affectationService.getAllAffectations();
        return new ResponseEntity<>(affectations, HttpStatus.OK);
    }

    // Update
    @PutMapping("/updateAff/{id}")
    public ResponseEntity<Affectation> updateAffectation(@PathVariable(value = "id") Long id,
            @RequestBody Affectation affectationDetails) {
        Affectation updatedAffectation = affectationService.updateAffectation(id, affectationDetails)
                .orElseThrow(() -> new NotFoundException("Affectation not found with id = " + id));
        return new ResponseEntity<>(updatedAffectation, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("DeleteAff/{id}")
    public ResponseEntity<Void> deleteAffectation(@PathVariable(value = "id") Long id) {
        affectationService.deleteAffectation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @GetMapping("/affectations/user/{userId}")
    public ResponseEntity<List<Affectation>> getAffectationsByUserId(@PathVariable Long userId) {
        List<Affectation> affectations = affectationService.getAllAffectationsByUserId(userId);
        return new ResponseEntity<>(affectations, HttpStatus.OK);
    }
}
