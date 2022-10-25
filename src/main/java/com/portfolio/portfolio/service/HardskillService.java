package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.HardSkill;
import com.portfolio.portfolio.repository.HardskillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HardskillService {
    @Autowired
    HardskillRepository hardskillRepository;

    public List<HardSkill> getHS(){
        return hardskillRepository.findAll();
    }


    public Optional<HardSkill> obtenerPorId(long id){
        return hardskillRepository.findById(id);
    }

    public void create(HardSkill hardSkill){
        hardskillRepository.save(hardSkill);
    }

    public void delete(long id){
        hardskillRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return hardskillRepository.existsById(id);
    }
}
