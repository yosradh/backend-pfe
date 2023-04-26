package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartech.app.Entities.Suivi_Mission;

@Repository
public interface Suivi_MissionRepository extends JpaRepository<Suivi_Mission, Long> {

}
