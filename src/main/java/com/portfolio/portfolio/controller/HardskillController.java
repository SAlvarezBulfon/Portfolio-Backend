package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.EstudioDTO;
import com.portfolio.portfolio.dto.HardskillsDTO;
import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.entity.Estudio;
import com.portfolio.portfolio.entity.HardSkill;
import com.portfolio.portfolio.repository.HardskillRepository;
import com.portfolio.portfolio.service.HardskillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardskill")
@CrossOrigin
public class HardskillController {
    @Autowired
    HardskillService hardskillService;

    @GetMapping("/hardskill")
    public ResponseEntity<List<HardSkill>> Hardskill(){
        List<HardSkill> hardSkills =hardskillService.getHS();
        return new ResponseEntity(hardSkills, HttpStatus.OK);
    }


    @PostMapping("/add")
    public  ResponseEntity<?> create(@RequestBody HardskillsDTO hardskillsDTO) {
        if (StringUtils.isBlank(hardskillsDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (hardskillsDTO.getPorcentaje() < 0 && hardskillsDTO.getPorcentaje() > 100) {
            return new ResponseEntity(new Mensaje("Debe ser mayor a 0 y menor igual que 100"), HttpStatus.BAD_REQUEST);
        }

        HardSkill hardSkill = new HardSkill(hardskillsDTO.getNombre(), hardskillsDTO.getPorcentaje());
        hardskillService.create(hardSkill);
        return new ResponseEntity(new Mensaje("Hardskill agregada con éxito"), HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteHardskill(@PathVariable("id") Long id){
            if(!hardskillService.existsById(id))
                return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
            hardskillService.delete(id);
            return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
        }
    }

