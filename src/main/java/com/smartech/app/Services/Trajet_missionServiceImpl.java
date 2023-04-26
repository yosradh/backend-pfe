package com.smartech.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartech.app.Entities.Trajet_mission;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.Trajet_MissionRepository;

@Service
public class Trajet_missionServiceImpl implements Trajet_missionService{

	private Trajet_MissionRepository Trajet_missionRepository;
    
    @Autowired
    public Trajet_missionServiceImpl(Trajet_MissionRepository Trajet_missionRepository) {
        super();
        this.Trajet_missionRepository = Trajet_missionRepository;
    }

    @Override
    public Trajet_mission saveTrajet_mission(Trajet_mission Trajet_mission) {
        return Trajet_missionRepository.save(Trajet_mission);
    }

    @Override
    public List<Trajet_mission> getAllTrajet_mission() {
        return Trajet_missionRepository.findAll();
    }

    @Override
    public Trajet_mission getTrajet_missionById(Long Id) {
        return Trajet_missionRepository.findById(Id).orElseThrow(()->
                new NotFoundException("Trajet_mission Id : ",Id));
    }

    @Override
    public Trajet_mission updateTrajet_mission(Trajet_mission Trajet_mission, long id){
    	Trajet_mission Trajet_missionExist = Trajet_missionRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Trajet_mission Id :",id));
    	Trajet_missionExist.setDateTrajet(Trajet_mission.getDateTrajet());
    	Trajet_missionExist.setPiecesJointes(Trajet_mission.getPiecesJointes());

    	Trajet_missionRepository.save(Trajet_missionExist);
        return Trajet_missionExist;
    }

    @Override
    public void deleteTrajet_mission(long id) {
    	Trajet_missionRepository.findById(id).orElseThrow(()->
                new NotFoundException("Trajet_mission Id :",id));
    	Trajet_missionRepository.deleteById(id);
    }
    
    
    @Override
    public List<Trajet_mission> getAllTrajet_missionsByUserId(Long userId) {
        return Trajet_missionRepository.findByAffectationUserId(userId);
    }

}
