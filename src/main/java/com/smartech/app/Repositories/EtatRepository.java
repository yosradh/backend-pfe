package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartech.app.Entities.Etat;

@Repository
public interface EtatRepository extends JpaRepository<Etat,Long> {
}
