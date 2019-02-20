package com.restful.api.resource;


import com.restful.api.model.Aerogerador;
import com.restful.api.repository.AerogeradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/aerogeradores")
public class AerogeradorResource {


    @Autowired
    AerogeradorRepository aerogeradorRepository;

    @GetMapping
    public ResponseEntity readAllAerogerador() {
        List<Aerogerador> aerogeradors = aerogeradorRepository.findAll();
        if (aerogeradors.isEmpty()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aerogeradors, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity readAerogerador(@PathVariable("id") Long id) {
        Aerogerador aerogerador = aerogeradorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complexo eolico não encontrado"));
        return new ResponseEntity<>(aerogerador, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createAerogerador( @Valid @RequestBody Aerogerador body) {
        Aerogerador aerogerador = aerogeradorRepository.save(body);
        return new ResponseEntity(aerogerador, HttpStatus.CREATED);
    }

//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity updateAerogerador(@PathVariable("id") Long id, @Valid @RequestBody Aerogerador body) {
//
//        Aerogerador aerogerador = aerogeradorRepository
//                .findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Complexo eolico não encontrado"));
//
//        aerogerador.setNome(body.getNome());
//        aerogerador.setUf(body.getUf());
//        aerogerador.setIdentificador(body.getIdentificador());
//
//        aerogeradorRepository.save(aerogerador);
//        return new ResponseEntity (aerogerador, HttpStatus.OK);
//    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAerogerador(@PathVariable("id") long id) {
        aerogeradorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complexo eolico não encontrado"));
        aerogeradorRepository.deleteById(id);
        return new ResponseEntity (HttpStatus.NO_CONTENT);
    }

}
