package com.smartech.app.Entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Affectations")
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "depart", nullable = false)
    //@NotEmpty(message = "depart is required")
    private String depart;

    @Column(name = "arrivee", nullable = false)
    //@NotEmpty(message = "arrivee is required")
    private String arrivee;
    
    @Column(name = "statusAff")
    private Boolean statusAff = false ;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "duration")
    private Integer duration; // nombre de jours pour les missions longue durée, null pour les missions courtes

    
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missions_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Mission mission;  
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Utilisateurs_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Utilisateurs user;
    
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transport_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MoyenTransport transport;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getDepart() {
		return depart;
	}
	
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	public String getArrivee() {
		return arrivee;
	}
	
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	
	public Boolean getStatusAff() {
		return statusAff;
	}
	
	public void setstatusAff(Boolean statusAff) {
		this.statusAff = statusAff;
	}
	
	public Mission getMission() {
		return mission;
	}
	
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	public MoyenTransport getTransport() {
		return transport;
	}
	
	public void setTransport(MoyenTransport transport) {
		this.transport = transport;
	}
	
	public Utilisateurs getUser() {
		return user;
	}
	
	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatusAff(Boolean statusAff) {
		this.statusAff = statusAff;
	}
	public Affectation(String depart, String arrivee, Boolean statusAff, LocalDate startDate, LocalDate endDate,String description,
			Integer duration, Utilisateurs user, MoyenTransport transport) {
		super();
		this.depart = depart;
		this.arrivee = arrivee;
		this.statusAff = statusAff;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.user = user;
		this.transport = transport;
	}

	
	public Affectation() {}
}
