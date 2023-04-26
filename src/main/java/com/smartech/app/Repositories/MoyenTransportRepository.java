package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartech.app.Entities.MoyenTransport;

@Repository
public interface MoyenTransportRepository extends JpaRepository<MoyenTransport, Long>{

}
