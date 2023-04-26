package com.smartech.app.Services;

import java.util.List;
import java.util.Optional;

import com.smartech.app.Entities.Affectation;

public interface AffectationService {

	List<Affectation> getAllAffectations();

	Optional<Affectation> getAffectationById(Long id);

	Affectation createAffectation(Affectation affectation);

	void deleteAffectation(Long id);

	List<Affectation> getAllAffectationsByMissionId(Long missionId);

	List<Affectation> deleteAllAffectationsByMissionId(Long missionId);

	Optional<Affectation> updateAffectation(Long id, Affectation affectationDetails);

	Affectation saveAffectation(Affectation Affectation);

	List<Affectation> getAllAffectationsByUserId(Long userId);
	
}
