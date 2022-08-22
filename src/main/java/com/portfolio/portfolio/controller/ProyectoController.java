package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.dto.ProyectoDTO;
import com.portfolio.portfolio.entity.Proyecto;
import com.portfolio.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/proyectos")
    public ResponseEntity<List<Proyecto>> getProjects() {
        List<Proyecto> list = proyectoService.getProjects();
        return new ResponseEntity<List<Proyecto>>(list, HttpStatus.OK);
    }


    @GetMapping("/details/(id)")
    public  ResponseEntity<Proyecto> getById(@PathVariable("id") long id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();
        return  new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        proyectoService.deleteProjects(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProject(@PathVariable("id") Long id,
                                         @RequestBody ProyectoDTO projectDTO){
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setName(projectDTO.getName());
        proyecto.setDescription(projectDTO.getDescription());
        proyecto.setUrl_image(projectDTO.getUrl_image());
        proyecto.setUrl_sourceCode(projectDTO.getUrl_sourceCode());
        proyectoService.saveProjects(proyecto);
        return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
    }
}
