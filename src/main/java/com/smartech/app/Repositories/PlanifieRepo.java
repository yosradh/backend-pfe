package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartech.app.Entities.MissionPlanifie;

@Repository
public interface PlanifieRepo extends JpaRepository<MissionPlanifie,Long> {
}