package com.smartech.app.Services;

import java.util.List;
import com.smartech.app.Entities.Trajet_mission;

public interface Trajet_missionService {

	Trajet_mission saveTrajet_mission(Trajet_mission Trajet_mission);
    List<Trajet_mission> getAllTrajet_mission();
    Trajet_mission getTrajet_missionById(Long Id);
    Trajet_mission updateTrajet_mission(Trajet_mission Trajet_mission,long id);
    void deleteTrajet_mission(long id);

    List<Trajet_mission> getAllTrajet_missionsByUserId(Long userId);
}
