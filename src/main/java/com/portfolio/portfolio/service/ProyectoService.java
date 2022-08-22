package com.portfolio.portfolio.service;

/*Imports*/
import com.portfolio.portfolio.entity.Proyecto;
import com.portfolio.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepository;

    /*Métodos CRUD*/
    public List<Proyecto> getProjects(){
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(long id){
        return proyectoRepository.findById(id);
    }
    public void saveProjects(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    public void deleteProjects(Long id) {
        proyectoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return proyectoRepository.existsById(id);
    }
}
