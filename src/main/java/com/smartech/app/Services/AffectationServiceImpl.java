package com.smartech.app.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartech.app.Entities.Affectation;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.AffectationRepository;
import com.smartech.app.Repositories.MissionRepository;
import com.smartech.app.Repositories.MoyenTransportRepository;
import com.smartech.app.Repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AffectationServiceImpl implements AffectationService {

    private AffectationRepository affectationRepository;
    private MissionRepository missionRepository;
    private MoyenTransportRepository moyenTransportRepository;
    private UserRepository utilisateurRepository;

    @Autowired
    public AffectationServiceImpl(AffectationRepository affectationRepository, MissionRepository missionRepository,
                                   MoyenTransportRepository moyenTransportRepository, UserRepository utilisateurRepository) {
        this.affectationRepository = affectationRepository;
        this.missionRepository = missionRepository;
        this.moyenTransportRepository = moyenTransportRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<Affectation> getAllAffectations() {
        return affectationRepository.findAllWithTransportAndAgent();
    }

    
    @Override
    public Optional<Affectation> getAffectationById(Long id) {
        return affectationRepository.findById(id);
    }
    
    @Override
    public Affectation saveAffectation(Affectation Affectation) {
        return affectationRepository.save(Affectation);
    }

    @Override
    public Affectation createAffectation(Affectation affectation) {
        // Vérifie si la mission existe
        Long missionId = affectation.getMission().getId();
        if (!missionRepository.existsById(missionId)) {
            throw new NotFoundException("Mission with id = " + missionId + " not found");
        }

        // Vérifie si le moyen de transport existe
        Long transportId = affectation.getTransport().getId();
        if (!moyenTransportRepository.existsById(transportId)) {
            throw new NotFoundException("Transport with id = " + transportId + " not found");
        }

        // Vérifie si l'utilisateur existe
        Long userId = affectation.getUser().getId();
        if (!utilisateurRepository.existsById(userId)) {
            throw new NotFoundException("User with id = " + userId + " not found");
        }

        return affectationRepository.save(affectation);
    }

    @Override
    public void deleteAffectation(Long id) {
        affectationRepository.deleteById(id);
    }

    @Override
    public List<Affectation> getAllAffectationsByMissionId(Long missionId) {
        if (!missionRepository.existsById(missionId)) {
            throw new NotFoundException("Mission with id = " + missionId + " not found");
        }
        return affectationRepository.findByMissionId(missionId);
    }

    @Override
    public List<Affectation> deleteAllAffectationsByMissionId(Long missionId) {
        if (!missionRepository.existsById(missionId)) {
            throw new NotFoundException("Mission with id = " + missionId + " not found");
        }
        List<Affectation> affectations = affectationRepository.findByMissionId(missionId);
        affectationRepository.deleteByMissionId(missionId);
        return affectations;
    }

    @Override
    public Optional<Affectation> updateAffectation(Long id, Affectation affectationDetails) {
        Optional<Affectation> affectation = affectationRepository.findById(id);
        if (affectation.isPresent()) {
            affectation.get().setDepart(affectationDetails.getDepart());
            affectation.get().setArrivee(affectationDetails.getArrivee());
            affectation.get().setstatusAff(affectationDetails.getStatusAff());
            //affectation.get().setMission(affectationDetails.getMission());
            //affectation.get().setTransport(affectationDetails.getTransport());
            //affectation.get().setUser(affectationDetails.getUser());
            affectationRepository.save(affectation.get());
            return Optional.of(affectation.get());
        } else {
            return Optional.empty();
        }
    }

    
    @Override
	 public List<Affectation> getAllAffectationsByUserId(Long userId) {
	        return affectationRepository.findByUserId(userId);
	    }
}
