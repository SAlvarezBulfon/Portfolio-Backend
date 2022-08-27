package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.dto.ProyectoDTO;
import com.portfolio.portfolio.entity.Proyecto;
import com.portfolio.portfolio.service.ProyectoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin
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

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectoDTO proyectoDto){
        if(StringUtils.isBlank(proyectoDto.getName())){
            return  new ResponseEntity(new Mensaje("El nombre del proyecto es obligarorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proyectoDto.getDescription())) {
            return  new ResponseEntity(new Mensaje("La descripción del proyecto es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proyectoDto.getUrl_image())) {
            return  new ResponseEntity(new Mensaje("La URL de la imagen del proyecto es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proyectoDto.getUrl_sourceCode())){
            return  new ResponseEntity(new Mensaje("La URL del proyecto es obligaroria"), HttpStatus.BAD_REQUEST);
        }
        Proyecto  proyecto = new Proyecto(proyectoDto.getName(), proyectoDto.getDescription(), proyectoDto.getUrl_image(), proyectoDto.getUrl_sourceCode());
        proyectoService.saveProjects(proyecto);
        return  new ResponseEntity(new Mensaje("¡Proyecto creado exitósamente"), HttpStatus.OK);
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
