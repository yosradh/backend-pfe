package com.smartech.app.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smartech.app.Entities.Etat;
import com.smartech.app.Entities.Mission;
import com.smartech.app.Entities.MissionLibre;
import com.smartech.app.Entities.MissionPlanifie;
import com.smartech.app.Entities.MoyenTransport;
import com.smartech.app.Entities.Suivi_Mission;
import com.smartech.app.Entities.PiecesJointes;
import com.smartech.app.Entities.Trajet_mission;
import com.smartech.app.Services.EtatService;
import com.smartech.app.Services.MissionService;
import com.smartech.app.Services.MoyenTranspService;
import com.smartech.app.Services.Suivi_MissionService;
import com.smartech.app.Services.Trajet_missionService;
import com.smartech.app.Services.PiecesJointesService;
import com.smartech.app.Repositories.LibreRepo;
import com.smartech.app.Repositories.PlanifieRepo;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/superviseur")
@CrossOrigin("*")
public class SupperviseurController {
    
	private EtatService EtatService;
	private MissionService MissionService;
	private MoyenTranspService  moyenTranspService;
	private Suivi_MissionService  Suivi_MissionService;
	private Trajet_missionService  Trajet_missionService;
	private PiecesJointesService  PiecesJointesService;
	private LibreRepo libreRepo;
	private PlanifieRepo planifieRepo;
	
    public SupperviseurController(PlanifieRepo planifieRepo, LibreRepo libreRepo,PiecesJointesService  PiecesJointesService,Trajet_missionService  Trajet_missionService,Suivi_MissionService  Suivi_MissionService,EtatService EtatService,MissionService MissionService,MoyenTranspService MoyenTranspService) {
        super();
        this.EtatService = EtatService;
        this.MissionService = MissionService;
        this.moyenTranspService = MoyenTranspService;
        this.Suivi_MissionService  = Suivi_MissionService;
        this.Trajet_missionService  = Trajet_missionService;
        this.PiecesJointesService = PiecesJointesService;
        this.libreRepo =libreRepo;
        this.planifieRepo = planifieRepo;

    }
    @PostMapping("/add")
    public ResponseEntity<Etat> saveEtat(@RequestBody Etat Etat){
        return new ResponseEntity<Etat>(EtatService.saveEtat(Etat), HttpStatus.CREATED);
    }
    @GetMapping("/show")
    public List<Etat> getAllEtat(){
        return EtatService.getAllEtat();
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<Etat> getEtatById(@PathVariable("id") long Id){
        return new ResponseEntity<Etat>(EtatService.getEtatById(Id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Etat> updateUser(@PathVariable("id") long id,
                                           @RequestBody Etat Etat){
        return new ResponseEntity<Etat>(EtatService.updateEtat(Etat,id),HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEtat(@PathVariable("id") long id){
        EtatService.deleteEtat(id);
        return new ResponseEntity<String>("moyen Etat deleted with success",HttpStatus.OK);
    }
    
    
    
    //**********************************Mission****************************************************************
    
    @PostMapping("/addMission")
    public ResponseEntity<Mission> saveMission(@RequestBody Mission mission){
        return new ResponseEntity<Mission>(MissionService.saveMission(mission), HttpStatus.CREATED);
    }
    @PostMapping("/addlibre")
    public ResponseEntity<MissionLibre> saveLibre(@RequestBody MissionLibre mLibre){
        return new ResponseEntity<MissionLibre>(MissionService.saveLibre(mLibre), HttpStatus.CREATED);
    }
    @PostMapping("/addplanifie")
    public ResponseEntity<MissionPlanifie> savePlanifie(@RequestBody MissionPlanifie mPlanifie){
        return new ResponseEntity<MissionPlanifie>(MissionService.savePlanifie(mPlanifie), HttpStatus.CREATED);
    }
    @GetMapping("/showMission")
    public List<Mission> getAllMission(){
        return MissionService.getAllMission();
    }
    
    @GetMapping("/showMission/{id}")
    public Optional<Mission> showAllMission(@PathVariable("id")long id){
        return MissionService.findById(id);
    }

    @GetMapping("viewL/{id}")
    public Mission getLibreId(@PathVariable("id")long id){
        return libreRepo.findById(id).get();
    }
    
    @GetMapping("viewP/{id}")
    public Mission getPlanifieId(@PathVariable("id")long id){
        return planifieRepo.findById(id).get();
    }
      
    @GetMapping("/showMission/Planifie")
    public List<MissionPlanifie> getMissionPlannifie(){
        return MissionService.getMissionPlannifie();
    }
    
    @GetMapping("/showMission/libre")
    public List<MissionLibre> getMissionLibre(){
        return MissionService.getMissionLibre();
    }
    
    //delete api
    @DeleteMapping("/deleteMission/{id}")
    public ResponseEntity<String> deleteMissionLibre(@PathVariable("id") long id){
    	MissionService.deleteMission(id);
        return new ResponseEntity<String>("Mission instantanné deleted with success",HttpStatus.OK);
    }
    
    
    @PutMapping("/updateMission/{id}")
    public ResponseEntity<Mission> updateMission(@PathVariable("id") long id,
                                           @RequestBody Mission Mission){
        return new ResponseEntity<Mission>(MissionService.updateMission(Mission,id),HttpStatus.OK);
    }
    
    //********************************** Transport *****************************************************************
    
    
    @PostMapping("/addV")
    public ResponseEntity<MoyenTransport> saveTransport(@RequestBody MoyenTransport transport){
        return new ResponseEntity<MoyenTransport>(moyenTranspService.saveTransport(transport), HttpStatus.CREATED);
    }
    @GetMapping("/showV")
    public List<MoyenTransport> getAllTransport(){
        return moyenTranspService.getAllTransport();
    }
    @GetMapping("/showV/{id}")
    public ResponseEntity<MoyenTransport> getTransportById(@PathVariable("id") long Id){
        return new ResponseEntity<MoyenTransport>(moyenTranspService.getTransportById(Id),HttpStatus.OK);
    }
    @PutMapping("/updateV/{id}")
    public ResponseEntity<MoyenTransport> updateUser(@PathVariable("id") long id,
                                           @RequestBody MoyenTransport transport){
        return new ResponseEntity<MoyenTransport>(moyenTranspService.updateTransport(transport,id),HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/deleteV/{id}")
    public ResponseEntity<String> deleteTransport(@PathVariable("id") long id){
        moyenTranspService.deleteTransport(id);
        return new ResponseEntity<String>("moyen transport deleted with success",HttpStatus.OK);
    }
    
    
    //***********************************Suivi_Mission****************************************************************
    
    @PostMapping("/addSuivi_Mission")
    public ResponseEntity<Suivi_Mission> saveSuivi_Mission(@RequestBody Suivi_Mission Suivi_Mission){
        return new ResponseEntity<Suivi_Mission>(Suivi_MissionService.saveSuivi_Mission(Suivi_Mission), HttpStatus.CREATED);
    }
    
    @GetMapping("/showSuivi_Mission")
    public List<Suivi_Mission> getAllSuivi_Mission(){
        return Suivi_MissionService.getAllSuivi_Mission();
    }
    @GetMapping("/showSuivi_Mission/{id}")
    public ResponseEntity<Suivi_Mission> getSuivi_MissionById(@PathVariable("id") long Id){
        return new ResponseEntity<Suivi_Mission>(Suivi_MissionService.getSuivi_MissionById(Id),HttpStatus.OK);
    }
    @PutMapping("/updateSuivi_Mission/{id}")
    public ResponseEntity<Suivi_Mission> updateSuivi_Mission(@PathVariable("id") long id,@RequestBody Suivi_Mission Suivi_Mission){
        return new ResponseEntity<Suivi_Mission>(Suivi_MissionService.updateSuivi_Mission(Suivi_Mission,id),HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/deleteSuivi_Mission/{id}")
    public ResponseEntity<String> deleteSuivi_Mission(@PathVariable("id") long id){
    	Suivi_MissionService.deleteSuivi_Mission(id);
        return new ResponseEntity<String>("Suivi_Mission deleted with success",HttpStatus.OK);
    }
    

   
  
    //*************************************trajet_Mission************************************************
    
    @PostMapping("/addTrajet")
    public ResponseEntity<Trajet_mission> saveTrajet_mission(@RequestBody Trajet_mission Trajet_mission){
        return new ResponseEntity<Trajet_mission>(Trajet_missionService.saveTrajet_mission(Trajet_mission), HttpStatus.CREATED);
    }
    
    @GetMapping("/showTrajet")
    public List<Trajet_mission> getAllTrajet_mission(){
        return Trajet_missionService.getAllTrajet_mission();
    }
    @GetMapping("/showTrajet/{id}")
    public ResponseEntity<Trajet_mission> getTrajet_missionById(@PathVariable("id") long Id){
        return new ResponseEntity<Trajet_mission>(Trajet_missionService.getTrajet_missionById(Id),HttpStatus.OK);
    }
    @PutMapping("/updateTrajet/{id}")
    public ResponseEntity<Trajet_mission> updateTrajet_mission(@PathVariable("id") long id,@RequestBody Trajet_mission Trajet_mission){
        return new ResponseEntity<Trajet_mission>(Trajet_missionService.updateTrajet_mission(Trajet_mission,id),HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/deleteTrajet/{id}")
    public ResponseEntity<String> deleteTrajet_mission(@PathVariable("id") long id){
    	Trajet_missionService.deleteTrajet_mission(id);
        return new ResponseEntity<String>("Trajet_mission deleted with success",HttpStatus.OK);
    }
    
    
    @GetMapping("/users/{userId}/trajets")
    public List<Trajet_mission> getTrajetsByUserId(@PathVariable Long userId) {
        return Trajet_missionService.getAllTrajet_missionsByUserId(userId);
    }


    
 //**********************************Pieces****************************************************************
    
    @PostMapping("/addPiece")
    public ResponseEntity<PiecesJointes> savePiecesJointes(@RequestBody PiecesJointes PiecesJointes){
        return new ResponseEntity<PiecesJointes>(PiecesJointesService.savePiecesJointes(PiecesJointes), HttpStatus.CREATED);
    }
    
    @GetMapping("/showPiece")
    public List<PiecesJointes> getAllPiece(){
        return PiecesJointesService.getAllPiecesJointes();
    }
    @GetMapping("/showPiece/{id}")
    public ResponseEntity<PiecesJointes> getPieceById1(@PathVariable("id") long Id){
        return new ResponseEntity<PiecesJointes>(PiecesJointesService.getPiecesJointesById(Id),HttpStatus.OK);
    }
    @PutMapping("/updatePiece/{id}")
    public ResponseEntity<PiecesJointes> updatePiece(@PathVariable("id") long id,@RequestBody PiecesJointes PiecesJointes){
        return new ResponseEntity<PiecesJointes>(PiecesJointesService.updatePiecesJointes(PiecesJointes,id),HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/deletePiece/{id}")
    public ResponseEntity<String> deletePiece(@PathVariable("id") long id){
    	PiecesJointesService.deletePiecesJointes(id);
        return new ResponseEntity<String>("PiecesJointes deleted with success",HttpStatus.OK);
    }
    
    
}
