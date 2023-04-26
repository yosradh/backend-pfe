package com.smartech.app.Entities;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;

@Entity
@Table(name = "pieces_jointes")
public class PiecesJointes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "heure", nullable = false)
    private LocalTime heure;

    @Column(name = "nom_fichier", nullable = false)
    private String nomFichier;

    @Column(name = "type", nullable = false)
    private String type; // ajout du champ type

    @Column(name = "description", nullable = false)
    private String description; // ajout du champ type
    
    @Lob
    @Column(name = "piece")
    private byte[] piece;

    @ManyToOne
    @JoinColumn(name = "trajetMission")
    private Trajet_mission trajetMission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPiece() {
		return piece;
	}

	public void setPiece(byte[] piece) {
		this.piece = piece;
	}

	public Trajet_mission getTrajetMission() {
		return trajetMission;
	}

	public void setTrajetMission(Trajet_mission trajetMission) {
		this.trajetMission = trajetMission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String Description) {
		this.description = Description;
	}
    
	
	public PiecesJointes(String nomFichier,String descritpion, byte[] piece) {
		this.description = descritpion;
		this.nomFichier = nomFichier;
		this.piece = piece;
	}
}
