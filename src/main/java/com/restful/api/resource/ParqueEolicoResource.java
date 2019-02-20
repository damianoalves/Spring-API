package com.restful.api.resource;

import com.restful.api.model.ParqueEolico;
import com.restful.api.repository.ParqueEolicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/parques-eolicos")
public class ParqueEolicoResource {

    @Autowired
    ParqueEolicoRepository parqueEolicoRepository;

    @GetMapping
    public ResponseEntity<List<ParqueEolico>> readAllParqueEolico() {
        List<ParqueEolico> parqueEolicos = parqueEolicoRepository.findAll();
        if (parqueEolicos.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(parqueEolicos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity readParqueEolico(@PathVariable("id") Long id) {
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(id);
        if (!parqueEolico.isPresent()) return new ResponseEntity (HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(parqueEolico, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParqueEolico> createParqueEolico(@Valid @RequestBody ParqueEolico body) {
        ParqueEolico parqueEolico = parqueEolicoRepository.save(body);
        return new ResponseEntity<>(parqueEolico, HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity updateParqueEolico(@PathVariable("id") Long id, @Valid @RequestBody ParqueEolico body) {
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(id);
        if (!parqueEolico.isPresent()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        parqueEolico.get().setNome(body.getNome());
        parqueEolico.get().setLatitude(body.getLatitude());
        parqueEolico.get().setLongitude(body.getLongitude());
        parqueEolico.get().setPotenciaInstalada(body.getPotenciaInstalada());
        parqueEolicoRepository.save(parqueEolico.get());
        return new ResponseEntity<>(parqueEolico, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteParqueEolico(@PathVariable("id") long id) {
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(id);
        if (!parqueEolico.isPresent()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        parqueEolicoRepository.deleteById(id);
        return new ResponseEntity (HttpStatus.NO_CONTENT);
    }

}
