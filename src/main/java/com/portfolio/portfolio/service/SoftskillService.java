package com.portfolio.portfolio.service;



import com.portfolio.portfolio.entity.Softskill;
import com.portfolio.portfolio.repository.SoftskillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SoftskillService {
    @Autowired
    SoftskillRepository softskillRepository;

    public List<Softskill> getSoftSkill(){
        return softskillRepository.findAll();
    }

    //Crear ---> Solo para poder crear uno por postman
    public void createSoftSkill(Softskill softskill){
        softskillRepository.save(softskill);
    }

    public Optional<Softskill> getOne(int id){
        return softskillRepository.findById(id);
    }
    public void deleteSoftSkill(int id) {
        softskillRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return softskillRepository.existsById(id);
    }
}
