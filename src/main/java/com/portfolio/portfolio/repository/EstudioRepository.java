package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository  extends JpaRepository<Estudio, Integer> {
}
