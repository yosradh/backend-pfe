package com.smartech.app.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "moyen_transport")
public class MoyenTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @NotEmpty
    @Column(name = "marque")
    private String marque;

    //@NotEmpty
    @Column(name = "matricule")
    private String matricule;

	
    public MoyenTransport() {}
    
    public MoyenTransport(String marque,String matricule) {
    	this.marque = marque;
    	this.matricule = matricule;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

    
}
