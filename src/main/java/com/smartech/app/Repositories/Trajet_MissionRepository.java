package com.smartech.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartech.app.Entities.Trajet_mission;

@Repository
public interface Trajet_MissionRepository extends JpaRepository<Trajet_mission, Long>{

	List<Trajet_mission> findByAffectationUserId(Long userId);

}
