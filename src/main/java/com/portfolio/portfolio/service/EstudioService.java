package com.portfolio.portfolio.service;


import com.portfolio.portfolio.entity.Estudio;
import com.portfolio.portfolio.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstudioService {
    @Autowired
    EstudioRepository estudioRepository;


    //Obtener todos los estudios
    public List<Estudio> getEstudios(){
        return estudioRepository.findAll();
    }

    //Obtener uno por id
    public Optional<Estudio> obtenerPorId(long id){
        return estudioRepository.findById(id);
    }

    //crear
    public void create(Estudio estudio){
        estudioRepository.save(estudio);
    }

    //borrar
    public void delete(long id){
        estudioRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return estudioRepository.existsById(id);
    }
}
