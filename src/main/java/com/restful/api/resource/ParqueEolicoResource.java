package com.restful.api.resource;

import com.restful.api.error.NotFoundException;
import com.restful.api.model.ComplexoEolico;
import com.restful.api.model.ParqueEolico;
import com.restful.api.repository.ComplexoEolicoRepository;
import com.restful.api.repository.ParqueEolicoRepository;
import io.swagger.annotations.Api;
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
@CrossOrigin(maxAge = 3600)
@RequestMapping(value="/", headers = {"Authorization"})
@Api( value = "Parque Eolico", description = "Serviços relacionados aos parques eólicos do sistema")
public class ParqueEolicoResource {

    @Autowired
    ParqueEolicoRepository parqueEolicoRepository;

    @Autowired
    ComplexoEolicoRepository complexoEolicoRepository;

    @ApiOperation(value = "Retorna todos os parques eólicos")
    @GetMapping(value = "complexos-eolicos/{complexoId}/parques-eolicos")
    public ResponseEntity<List<ParqueEolico>> readAllParqueEolico (
            @PathVariable("complexoId") Long complexoId ) throws NotFoundException {
        List<ParqueEolico> parqueEolicos = parqueEolicoRepository.findByComplexoEolicoId(complexoId);
        if (parqueEolicos.isEmpty()) throw new NotFoundException("Parques eólicos não encontrados");
        return new ResponseEntity<>(parqueEolicos, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna um parque eólico")
    @GetMapping(value = "complexos-eolicos/{complexoId}/parques-eolicos/{parqueId}")
    public ResponseEntity readParqueEolico (
            @PathVariable("complexoId") Long complexoId,
            @PathVariable("parqueId") Long parqueId ) {
        Optional<ComplexoEolico> complexoEolico = complexoEolicoRepository.findById(complexoId);
        if (!complexoEolico.isPresent()) throw new NotFoundException("Complexo eólico não encontrado");
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(parqueId);
        if (!parqueEolico.isPresent()) throw new NotFoundException("Parque eólico não encontrado");
        return new ResponseEntity<>(parqueEolico, HttpStatus.OK);
    }

    @ApiOperation(value = "Cadastra um parque eólico")
    @PostMapping(value = "complexos-eolicos/{complexoId}/parques-eolicos")
    public ResponseEntity<ParqueEolico> createParqueEolico (
            @PathVariable("complexoId") Long complexoId,
            @Valid @RequestBody ParqueEolico body ) {
        Optional<ComplexoEolico> complexoEolico = complexoEolicoRepository.findById(complexoId);
        if (!complexoEolico.isPresent()) throw new NotFoundException("Complexo eólico não encontrado");
        body.setComplexoEolico(complexoEolico.get());
        ParqueEolico parqueEolico = parqueEolicoRepository.save(body);
        return new ResponseEntity<>(parqueEolico, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Modifica um parque eólico")
    @PutMapping(value = "complexos-eolicos/{complexoId}/parques-eolicos/{parqueId}")
    public ResponseEntity updateParqueEolico(
            @PathVariable("complexoId") Long complexoId,
            @PathVariable("parqueId") Long parqueId,
            @Valid @RequestBody ParqueEolico body ) {
        Optional<ComplexoEolico> complexoEolico = complexoEolicoRepository.findById(complexoId);
        if (!complexoEolico.isPresent()) throw new NotFoundException("Complexo eólico não encontrado");
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(parqueId);
        if (!parqueEolico.isPresent()) throw new NotFoundException("Parque eólico não encontrado");
        parqueEolico.get().setNome(body.getNome());
        parqueEolico.get().setLatitude(body.getLatitude());
        parqueEolico.get().setLongitude(body.getLongitude());
        parqueEolico.get().setPotenciaInstalada(body.getPotenciaInstalada());
        parqueEolicoRepository.save(parqueEolico.get());
        return new ResponseEntity<>(parqueEolico, HttpStatus.OK);
    }

    @ApiOperation(value = "Remove um parque eólico")
    @DeleteMapping(value = "complexos-eolicos/{complexoId}/parques-eolicos/{parqueId}")
    public ResponseEntity deleteParqueEolico(
            @PathVariable("complexoId") Long complexoId,
            @PathVariable("parqueId") Long parqueId ) {
        Optional<ComplexoEolico> complexoEolico = complexoEolicoRepository.findById(complexoId);
        if (!complexoEolico.isPresent()) throw new NotFoundException("Complexo eólico não encontrado");
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(parqueId);
        if (!parqueEolico.isPresent()) throw new NotFoundException("Parque eólico não encontrado");
        parqueEolicoRepository.deleteById(parqueId);
        return new ResponseEntity (HttpStatus.NO_CONTENT);
    }
}
