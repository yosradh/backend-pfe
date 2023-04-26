package com.smartech.app.Entities;


import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "suivi_mission")
public class Suivi_Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trajet_mission_id", referencedColumnName = "id")
    private Trajet_mission trajetMission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_id", referencedColumnName = "id")
    private Etat etat;

    @Column(name = "date_suivi")
    private LocalDate dateSuivi;

    @Column(name = "createur")
    private String createur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trajet_mission getTrajetMission() {
		return trajetMission;
	}

	public void setTrajetMission(Trajet_mission trajetMission) {
		this.trajetMission = trajetMission;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public LocalDate getDateSuivi() {
		return dateSuivi;
	}

	public void setDateSuivi(LocalDate dateSuivi) {
		this.dateSuivi = dateSuivi;
	}

	public String getCreateur() {
		return createur;
	}

	public void setCreateur(String createur) {
		this.createur = createur;
	}
	

	public Suivi_Mission () {}

	public Suivi_Mission(Long id, Trajet_mission trajetMission, Etat etat, LocalDate dateSuivi, String createur) {
		super();
		this.id = id;
		this.trajetMission = trajetMission;
		this.etat = etat;
		this.dateSuivi = dateSuivi;
		this.createur = createur;
	}
	
	
    
}
