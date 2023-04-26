package com.smartech.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartech.app.Entities.PiecesJointes;

@Repository
public interface PiecesJointesRepository extends JpaRepository<PiecesJointes, Long>{

	//Optional<PiecesJointes> findPiecesJointesById(Long id);

}
