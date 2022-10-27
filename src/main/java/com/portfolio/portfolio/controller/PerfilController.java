package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.AboutDTO;
import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.dto.PerfilDTO;
import com.portfolio.portfolio.entity.About;
import com.portfolio.portfolio.entity.Perfil;
import com.portfolio.portfolio.service.AboutService;
import com.portfolio.portfolio.service.PerfilService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/perfil")
@CrossOrigin
public class PerfilController {
    @Autowired
    PerfilService perfilService;

    @GetMapping("/datos")
    public ResponseEntity<List<Perfil>> list(){
        List<Perfil> List = perfilService.getPerfil();
        return  new ResponseEntity<List<Perfil>>(List, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> createPerfil(@RequestBody PerfilDTO perfilDTO){
        if(StringUtils.isBlank(perfilDTO.getNombre())){
            return new ResponseEntity(new Mensaje("Su nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(perfilDTO.getPuesto())){
            return new ResponseEntity(new Mensaje("El puesto al que postula o ejerce es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Perfil perfil = new Perfil(perfilDTO.getNombre(), perfilDTO.getPuesto());
        perfilService.createPerfil(perfil);
        return new ResponseEntity(new Mensaje("Perfil creado correctamente"), HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public  ResponseEntity<?> editPerfil(@PathVariable("id") int id, @RequestBody PerfilDTO perfilDTO){
        if(StringUtils.isBlank(perfilDTO.getNombre())){
            return new ResponseEntity(new Mensaje("Su nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(perfilDTO.getPuesto())){
            return new ResponseEntity(new Mensaje("El puesto que tiene o desea ejercer obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Perfil perfil = perfilService.getOne(id).get();
        perfil.setNombre(perfilDTO.getNombre());
        perfil.setPuesto(perfilDTO.getPuesto());
        perfilService.createPerfil(perfil);
        return new ResponseEntity(new Mensaje("Perfil Editado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerfil(@PathVariable("id") int id){
        if(!perfilService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        perfilService.deletePerfil(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
}
