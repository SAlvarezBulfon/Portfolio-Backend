package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardskillRepository extends JpaRepository<HardSkill, Long> {
}
