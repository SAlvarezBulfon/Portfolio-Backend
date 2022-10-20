package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.AboutDTO;
import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.dto.SoftskillDTO;
import com.portfolio.portfolio.entity.About;
import com.portfolio.portfolio.entity.Softskill;
import com.portfolio.portfolio.service.AboutService;
import com.portfolio.portfolio.service.SoftskillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/softskill")
@CrossOrigin
public class SoftskillController {

    @Autowired
    SoftskillService sfService;

    @GetMapping("/description")
    public ResponseEntity<List<Softskill>> list(){
        List<Softskill> List = sfService.getSoftSkill();
        return  new ResponseEntity<List<Softskill>>(List, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> createSoftSkill(@RequestBody SoftskillDTO sfDTO){
        if(StringUtils.isBlank(sfDTO.getDescription())){
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Softskill sf = new Softskill(sfDTO.getDescription());
        sfService.createSoftSkill(sf);
        return new ResponseEntity(new Mensaje("Descripción de SoftSkill creada correctamente"), HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public  ResponseEntity<?> editAbout(@PathVariable("id") int id, @RequestBody SoftskillDTO sfDTO){
        if(StringUtils.isBlank(sfDTO.getDescription())){
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Softskill sf = sfService.getOne(id).get();
        sf.setDescription(sfDTO.getDescription());
        sfService.createSoftSkill(sf);
        return new ResponseEntity(new Mensaje("Descripcion de SoftSkills Editada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSoftSkill(@PathVariable("id") int id){
        if(!sfService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        sfService.deleteSoftSkill(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
}
