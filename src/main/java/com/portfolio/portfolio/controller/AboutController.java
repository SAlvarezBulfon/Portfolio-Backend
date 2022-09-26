package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.Mensaje;
import com.portfolio.portfolio.entity.Proyecto;
import org.apache.commons.lang3.StringUtils;
import com.portfolio.portfolio.dto.AboutDTO;
import com.portfolio.portfolio.entity.About;
import com.portfolio.portfolio.service.AboutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about")
@CrossOrigin
public class AboutController {
    AboutService aboutService;

    @GetMapping("/description")
    public ResponseEntity<List<About>> list(){
        List<About> List = aboutService.getAbout();
        return  new ResponseEntity<List<About>>(List, HttpStatus.OK);
    }

    @PostMapping("/createAbout")
    public  ResponseEntity<?> createAbout(@RequestBody AboutDTO aboutDTO){
        if(StringUtils.isBlank(aboutDTO.getDescription1())){
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(aboutDTO.getDescription2())){
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(aboutDTO.getUrl_CV())){
            return new ResponseEntity(new Mensaje("El link del CV es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        About about = new About( aboutDTO.getDescription1(), aboutDTO.getDescription2(), aboutDTO.getUrl_CV());
        aboutService.createAbout(about);
        return new ResponseEntity(new Mensaje("About creado correctamente"), HttpStatus.OK);
    }


    @PostMapping("/editAbout/{id}")
    public  ResponseEntity<?> editAbout(@PathVariable("id") int id, @RequestBody AboutDTO aboutDTO){
        if(StringUtils.isBlank(aboutDTO.getDescription1())){
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(aboutDTO.getDescription2())){
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(aboutDTO.getUrl_CV())){
            return new ResponseEntity(new Mensaje("El link del CV es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        About about = aboutService.getOne(id).get();
        about.setDescription1(aboutDTO.getDescription1());
        about.setDescription2(aboutDTO.getDescription2());
        about.setUrl_CV(aboutDTO.getUrl_CV());
        aboutService.createAbout(about);
        return new ResponseEntity(new Mensaje("About Editado"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAbout/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") int id){
        if(!aboutService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        aboutService.deleteAbout(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
}
