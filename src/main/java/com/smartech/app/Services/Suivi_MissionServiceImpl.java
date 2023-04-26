package com.smartech.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.app.Entities.Suivi_Mission;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.Suivi_MissionRepository;

@Service
public class Suivi_MissionServiceImpl implements Suivi_MissionService {

    private Suivi_MissionRepository Suivi_MissionRepository;
    
    @Autowired
    public Suivi_MissionServiceImpl(Suivi_MissionRepository Suivi_MissionRepository) {
        super();
        this.Suivi_MissionRepository = Suivi_MissionRepository;
    }

    @Override
    public Suivi_Mission saveSuivi_Mission(Suivi_Mission Suivi_Mission) {
        return Suivi_MissionRepository.save(Suivi_Mission);
    }

    @Override
    public List<Suivi_Mission> getAllSuivi_Mission() {
        return Suivi_MissionRepository.findAll();
    }

    @Override
    public Suivi_Mission getSuivi_MissionById(Long Id) {
        return Suivi_MissionRepository.findById(Id).orElseThrow(()->
                new NotFoundException("Suivi_Mission Id : ",Id));
    }

    @Override
    public Suivi_Mission updateSuivi_Mission(Suivi_Mission Suivi_Mission, long id){
    	Suivi_Mission Suivi_MissionExist = Suivi_MissionRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Suivi_Mission Id :",id));
    	Suivi_MissionExist.setTrajetMission(Suivi_Mission.getTrajetMission());
    	Suivi_MissionRepository.save(Suivi_MissionExist);
        return Suivi_MissionExist;
    }

    @Override
    public void deleteSuivi_Mission(long id) {
    	Suivi_MissionRepository.findById(id).orElseThrow(()->
                new NotFoundException("Suivi_Mission Id :",id));
    	Suivi_MissionRepository.deleteById(id);
    }

    }

