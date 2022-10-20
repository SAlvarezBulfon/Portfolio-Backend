package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.About;
import com.portfolio.portfolio.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
