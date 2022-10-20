package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.EstudioDTO;
import com.portfolio.portfolio.dto.ExperienciaDTO;
import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.entity.Estudio;
import com.portfolio.portfolio.entity.Experiencia;
import com.portfolio.portfolio.service.EstudioService;
import com.portfolio.portfolio.service.ExperienciaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/puestos")
    public ResponseEntity<List<Experiencia>> Estudios(){
        List<Experiencia> estudios = experienciaService.getPuesto();
        return new ResponseEntity(estudios, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<?> create(@RequestBody ExperienciaDTO exDTO){
        if (StringUtils.isBlank(exDTO.getTitle())) {
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exDTO.getDescription())) {
            return  new ResponseEntity(new Mensaje("La descripción es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exDTO.getTime())) {
            return  new ResponseEntity(new Mensaje("la duración es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(exDTO.getTitle(), exDTO.getTime(), exDTO.getDescription());
        experienciaService.create(experiencia);
        return  new ResponseEntity(new Mensaje("Experiencia laboral agregada con éxito"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public  ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ExperienciaDTO exDTO){
        if (StringUtils.isBlank(exDTO.getTitle())) {
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exDTO.getDescription())) {
            return  new ResponseEntity(new Mensaje("La descripción es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exDTO.getTime())) {
            return  new ResponseEntity(new Mensaje("la duración es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = experienciaService.obtenerPorId(id).get();
        experiencia.setTitle(exDTO.getTitle());
        experiencia.setTime(exDTO.getTime());
        experiencia.setDescription(exDTO.getDescription());
        experienciaService.create(experiencia);
        return  new ResponseEntity(new Mensaje("Experiencia laboral actualizada con éxito"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExp(@PathVariable("id") Long id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
}
