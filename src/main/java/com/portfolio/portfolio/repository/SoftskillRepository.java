package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Softskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftskillRepository extends JpaRepository<Softskill, Integer> {
}
