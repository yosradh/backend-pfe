package com.smartech.app.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "MissionPlanifie")
public class MissionPlanifie extends Mission{
	
    private String typeP = "Planifié";

    public MissionPlanifie() {
        super();
    }

    public MissionPlanifie(Long id, String nom, String description, String typeP) {
        super(id, nom, description);
        this.typeP = typeP;
    }

    public String getTypeP() {
        return typeP;
    }

    public void setTypeP(String typeP) {
        this.typeP = typeP;
    }
}