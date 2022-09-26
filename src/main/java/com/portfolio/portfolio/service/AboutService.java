package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.About;
import com.portfolio.portfolio.entity.Proyecto;
import com.portfolio.portfolio.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutService {
    @Autowired
    AboutRepository aboutRepository;

    public List<About> getAbout(){
        return aboutRepository.findAll();
    }

    //Crear ---> Solo para poder crear uno por postman
    public void createAbout(About about){
        aboutRepository.save(about);
    }

    public Optional<About> getOne(int id){
        return aboutRepository.findById(id);
    }
    public void deleteAbout(int id) {
        aboutRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return aboutRepository.existsById(id);
    }

}
