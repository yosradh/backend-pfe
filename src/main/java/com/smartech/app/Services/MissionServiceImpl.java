package com.smartech.app.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartech.app.Entities.Mission;
import com.smartech.app.Entities.MissionLibre;
import com.smartech.app.Entities.MissionPlanifie;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.MissionRepository;
import com.smartech.app.Repositories.LibreRepo;
import com.smartech.app.Repositories.PlanifieRepo;

@Service
public class MissionServiceImpl implements MissionService {
   private MissionRepository missionRepo;
   private LibreRepo libreRepo;
   private PlanifieRepo planifieRepo;
@Autowired
   public MissionServiceImpl(MissionRepository missionRepo, LibreRepo libreRepo, PlanifieRepo planifieRepo) {
       this.missionRepo = missionRepo;
       this.libreRepo = libreRepo;
       this.planifieRepo = planifieRepo;
   }

   @Override
   public Mission saveMission(Mission mission) {
       return missionRepo.save(mission);
   }

   @Override
   public MissionPlanifie savePlanifie(MissionPlanifie mplanifie) {
       return planifieRepo.save(mplanifie);
   }

   @Override
   public MissionLibre saveLibre(MissionLibre mLibre) {
       return libreRepo.save(mLibre);
   }

   @Override
   public List<Mission> getAllMission() {
       return missionRepo.findAll();
   }
   @Override
   public List<MissionLibre>getMissionLibre(){
	   return libreRepo.findAll();
   }
   @Override
   public List<MissionPlanifie>getMissionPlannifie(){
	   return planifieRepo.findAll();
   }
   
   @Override
   public void deleteMission(long id) {
	  
	   missionRepo.findById(id).orElseThrow(()->
       new NotFoundException("Mission ,Id",id));
	   missionRepo.deleteById(id);
	  
   }
   
   
   @Override
   public Mission updateMission(Mission Mission, long id) {
	   Mission MissionExist = missionRepo.findById(id).orElseThrow(
               ()-> new NotFoundException("Etat, Id",id));
	   MissionExist.setNom(Mission.getNom());
	   MissionExist.setDescription(Mission.getDescription());

	   missionRepo.save(MissionExist);
       return MissionExist;
   }

   

	@Override
	public Optional<Mission> findById(long id) {
		  return missionRepo.findById(id);
	}
}
