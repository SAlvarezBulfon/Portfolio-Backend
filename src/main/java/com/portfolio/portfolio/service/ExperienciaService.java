package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Experiencia;
import com.portfolio.portfolio.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;


    //Obtener todos los estudios
    public List<Experiencia> getPuesto(){
        return experienciaRepository.findAll();
    }

    //Obtener uno por id
    public Optional<Experiencia> obtenerPorId(long id){
        return experienciaRepository.findById(id);
    }

    //crear
    public void create(Experiencia experiencia){
        experienciaRepository.save(experiencia);
    }

    //borrar
    public void deleteExperiencia(long id){
        experienciaRepository.deleteById(id);
    }
    public boolean existsById(long id) {
        return experienciaRepository.existsById(id);
    }
}