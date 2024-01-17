package com.demo.bestjugs.repository;

import com.demo.bestjugs.model.BoulderingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoulderingSessionRepository extends JpaRepository<BoulderingSession, Long> {

}
