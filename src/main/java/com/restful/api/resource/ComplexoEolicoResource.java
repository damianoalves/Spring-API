package com.restful.api.resource;

import com.restful.api.error.ErrorHandler;
import com.restful.api.model.ComplexoEolico;
import com.restful.api.repository.ComplexoEolicoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author Damiano Alves on 20/02/19
 * damiano.alves@gmail.com
 */

@RestController
@RequestMapping(value="/")
public class ComplexoEolicoResource extends ErrorHandler {

    @Autowired
    ComplexoEolicoRepository complexoEolicoRepository;

    @ApiOperation(value = "Retorna todos os complexos eólicos")
    @GetMapping(value = "complexos-eolicos")
    public ResponseEntity<List<ComplexoEolico>> readAllComplexoEolico() {
        List<ComplexoEolico> complexoEolicos = complexoEolicoRepository.findAll();
        if (complexoEolicos.isEmpty()) return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(complexoEolicos, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna um complexo eólico")
    @GetMapping(value = "complexos-eolicos/{id}")
    public ResponseEntity readComplexoEolico(@PathVariable("id") Long id) {
        Optional<ComplexoEolico> complexoEolico = complexoEolicoRepository.findById(id);
        if (!complexoEolico.isPresent()) return new ResponseEntity (HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(complexoEolico, HttpStatus.OK);
    }

    @ApiOperation(value = "Cadastra um complexo eólico")
    @PostMapping(value = "complexos-eolicos")
    public ResponseEntity<ComplexoEolico> createComplexoEolico(@Valid @RequestBody ComplexoEolico body) {
        ComplexoEolico complexoEolico = complexoEolicoRepository.save(body);
        return new ResponseEntity<>(complexoEolico, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Modifica um complexo eólico")
    @PutMapping(value = "complexos-eolicos/{id}")
    public ResponseEntity updateComplexoEolico(
            @PathVariable("id") Long id,
            @Valid @RequestBody ComplexoEolico body) {
        Optional<ComplexoEolico> complexoEolico = complexoEolicoRepository.findById(id);
        if (!complexoEolico.isPresent()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        complexoEolico.get().setNome(body.getNome());
        complexoEolico.get().setUf(body.getUf());
        complexoEolico.get().setIdentificador(body.getIdentificador());
        complexoEolicoRepository.save(complexoEolico.get());
        return new ResponseEntity<>(complexoEolico, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Remove um complexo eólico")
    @DeleteMapping(value = "complexos-eolicos/{id}")
    public ResponseEntity deleteComplexoEolico(@PathVariable("id") long id) {
        Optional<ComplexoEolico> complexoEolico = complexoEolicoRepository.findById(id);
        if (!complexoEolico.isPresent()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        complexoEolicoRepository.deleteById(id);
        return new ResponseEntity (HttpStatus.NO_CONTENT);
    }



}