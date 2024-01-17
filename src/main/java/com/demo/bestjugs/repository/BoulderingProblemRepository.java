package com.demo.bestjugs.repository;

import com.demo.bestjugs.model.BoulderingProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoulderingProblemRepository extends JpaRepository<BoulderingProblem, Long> {
}
