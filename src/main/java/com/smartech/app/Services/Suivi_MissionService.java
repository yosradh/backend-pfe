package com.smartech.app.Services;

import java.util.List;

import com.smartech.app.Entities.Suivi_Mission;

public interface Suivi_MissionService {
	
	Suivi_Mission saveSuivi_Mission(Suivi_Mission User);
    List<Suivi_Mission> getAllSuivi_Mission();
    Suivi_Mission getSuivi_MissionById(Long Id);
    Suivi_Mission updateSuivi_Mission(Suivi_Mission Suivi_Mission,long id);
    void deleteSuivi_Mission(long id);
}