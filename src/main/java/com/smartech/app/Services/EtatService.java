package com.smartech.app.Services;

import java.util.List;

import com.smartech.app.Entities.Etat;

public interface EtatService {
    Etat saveEtat(Etat Etat);
    List<Etat> getAllEtat();
    Etat getEtatById(Long Id);
    Etat updateEtat(Etat Etat,long id);
    void deleteEtat(long id);
}
