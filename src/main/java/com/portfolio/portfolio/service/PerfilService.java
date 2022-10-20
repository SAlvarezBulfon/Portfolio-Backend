package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Perfil;
import com.portfolio.portfolio.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PerfilService {
    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> getPerfil(){
        return perfilRepository.findAll();
    }

    //Crear ---> Solo para poder crear uno por postman
    public void createPerfil(Perfil perfil){
        perfilRepository.save(perfil);
    }

    public Optional<Perfil> getOne(int id){
        return perfilRepository.findById(id);
    }

    public void deletePerfil(int id) {
        perfilRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return perfilRepository.existsById(id);
    }
}
