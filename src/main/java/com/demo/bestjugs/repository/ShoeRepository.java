package com.demo.bestjugs.repository;

import com.demo.bestjugs.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {

}
