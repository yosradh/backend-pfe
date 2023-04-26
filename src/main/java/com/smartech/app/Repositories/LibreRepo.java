package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartech.app.Entities.MissionLibre;

@Repository
public interface LibreRepo extends JpaRepository<MissionLibre,Long> {
}