package com.smartech.app.Services;

import java.util.List;
import java.util.Optional;

import com.smartech.app.Entities.Mission;
import com.smartech.app.Entities.MissionLibre;
import com.smartech.app.Entities.MissionPlanifie;

public interface MissionService {
    Mission saveMission(Mission mission);
    MissionPlanifie savePlanifie(MissionPlanifie mplanifie);
    MissionLibre saveLibre(MissionLibre mLibre);
    List<Mission> getAllMission();
	List<MissionLibre> getMissionLibre();
	List<MissionPlanifie> getMissionPlannifie();
	void deleteMission(long id);
	Mission updateMission(Mission Mission, long id);
	Optional<Mission> findById(long id);

}