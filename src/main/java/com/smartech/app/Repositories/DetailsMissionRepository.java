package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartech.app.Entities.Details_Mission;

@Repository
public interface DetailsMissionRepository extends JpaRepository<Details_Mission, Long>{

}
