package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartech.app.Entities.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {

}