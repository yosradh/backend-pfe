package com.smartech.app.Entities;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trajet_mission")
public class Trajet_mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_trajet")
    private LocalDate dateTrajet;

    @OneToMany(mappedBy = "trajetMission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PiecesJointes> piecesJointes = new ArrayList<>();
    
    
    @OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "affectation_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Affectation affectation;  


    public Trajet_mission() {}
    

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getDateTrajet() {
		return dateTrajet;
	}


	public void setDateTrajet(LocalDate dateTrajet) {
		this.dateTrajet = dateTrajet;
	}




	public Affectation getAffectation() {
		return affectation;
	}


	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}


	public List<PiecesJointes> getPiecesJointes() {
		return piecesJointes;
	}


	public void setPiecesJointes(List<PiecesJointes> piecesJointes) {
		this.piecesJointes = piecesJointes;
	}


	public Trajet_mission(Long id, LocalDate dateTrajet, List<PiecesJointes> piecesJointes,
			Affectation affectation) {
		super();
		this.id = id;
		this.dateTrajet = dateTrajet;
		this.piecesJointes = piecesJointes;
		this.affectation = affectation;
	}


    
    
}
