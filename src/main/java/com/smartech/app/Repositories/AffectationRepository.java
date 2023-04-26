package com.smartech.app.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.smartech.app.Entities.Affectation;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {

  // Retourne toutes les affectations associées à une mission donnée
  List<Affectation> findByMissionId(Long missionId);

  // Supprime toutes les affectations associées à une mission donnée
  void deleteByMissionId(Long missionId);

  // Retourne toutes les affectations associées à un utilisateur donné
  List<Affectation> findByUserId(Long userId);

  // Supprime toutes les affectations associées à un utilisateur donné
  void deleteByUserId(Long userId);

  // Retourne toutes les affectations associées à un moyen de transport donné
  List<Affectation> findByTransportId(Long transportId);

  // Supprime toutes les affectations associées à un moyen de transport donné
  void deleteByTransportId(Long transportId);
  
  
  @Query("SELECT a FROM Affectation a JOIN FETCH a.transport JOIN FETCH a.user")
  List<Affectation> findAllWithTransportAndAgent();
}
