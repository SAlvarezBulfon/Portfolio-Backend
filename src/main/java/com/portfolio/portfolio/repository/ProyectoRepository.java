package com.portfolio.portfolio.repository;
/*Imports*/
import com.portfolio.portfolio.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indica que es un repositorio
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
}
