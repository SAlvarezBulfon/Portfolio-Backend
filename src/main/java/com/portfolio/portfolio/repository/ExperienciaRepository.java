package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Estudio;
import com.portfolio.portfolio.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository  extends JpaRepository<Experiencia, Long> {
}