package com.smartech.app.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Details_Mission")
public class Details_Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "Affectation_id")
    //private Affectation affectation;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trajet_mission_id")
    private Trajet_mission trajetMission;
    
    @Column(name = "longitude", nullable = false)
    private Double longitude;
    
    @Column(name = "latitude", nullable = false)
    private Double latitude;
    
    @Column(name = "adresse", nullable = false)
    private String adresse;

	@Override
	public String toString() {
		return "Details_Mission [id=" + id + ", trajetMission=" + trajetMission
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", adresse=" + adresse + "]";
	}

    
}

