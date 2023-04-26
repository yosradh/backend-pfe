package com.smartech.app.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "MissionLibre")
public class MissionLibre extends Mission{
    
	private String typeL="Instantannée";
    
	public MissionLibre() {
        super();
    }

    public MissionLibre(Long id, String nom, String description, String typeL) {
        super(id, nom, description);
        this.typeL = typeL;
    }

    public String getTypeL() {
        return typeL;
    }

    public void setTypeL(String typeL) {
        this.typeL = typeL;
    }

}