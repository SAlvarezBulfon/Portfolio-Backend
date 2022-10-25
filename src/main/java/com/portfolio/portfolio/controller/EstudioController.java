package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.EstudioDTO;
import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.entity.Estudio;
import com.portfolio.portfolio.service.EstudioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudio")
@CrossOrigin
public class EstudioController {
    @Autowired
    EstudioService estudioService;

    @GetMapping("/estudios")
    public ResponseEntity<List<Estudio>> Estudios(){
        List<Estudio> estudios = estudioService.getEstudios();
        return new ResponseEntity(estudios, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<?> create(@RequestBody EstudioDTO estudioDTO){
        if (StringUtils.isBlank(estudioDTO.getTitle())) {
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(estudioDTO.getDescription())) {
            return  new ResponseEntity(new Mensaje("La descripción es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(estudioDTO.getTime())) {
            return  new ResponseEntity(new Mensaje("la duración es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        Estudio estudio = new Estudio(estudioDTO.getTitle(), estudioDTO.getTime(), estudioDTO.getDescription());
        estudioService.create(estudio);
        return  new ResponseEntity(new Mensaje("Formación académica agregada con éxito"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public  ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody EstudioDTO estudioDTO){
        if (StringUtils.isBlank(estudioDTO.getTitle())) {
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(estudioDTO.getDescription())) {
            return  new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(estudioDTO.getTime())) {
            return  new ResponseEntity(new Mensaje("la duración es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Estudio estudio = estudioService.obtenerPorId(id).get();
        estudio.setTitle(estudioDTO.getTitle());
        estudio.setTime(estudioDTO.getTime());
        estudio.setDescription(estudioDTO.getDescription());
        estudioService.create(estudio);
        return  new ResponseEntity(new Mensaje("Formación académica actualizada con éxito"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEstudio(@PathVariable("id") Long id){
        if(!estudioService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        estudioService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

}
