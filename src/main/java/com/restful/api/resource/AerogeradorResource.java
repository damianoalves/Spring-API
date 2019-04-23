package com.restful.api.resource;


import com.restful.api.error.NotFoundException;
import com.restful.api.model.Aerogerador;
import com.restful.api.model.ParqueEolico;
import com.restful.api.repository.AerogeradorRepository;
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
@Api(value = "Aerogerador", description = "Serviços relacionados aos aerogeradores do sistema")
public class AerogeradorResource {

    @Autowired
    ParqueEolicoRepository parqueEolicoRepository;

    @Autowired
    AerogeradorRepository aerogeradorRepository;


    @ApiOperation(value = "Retorna todos os aerogeradores de um parque eólico")
    @GetMapping(value = "parques-eolicos/{parqueId}/aerogeradores")
    public ResponseEntity<List<Aerogerador>> readAllAerogerador(
            @PathVariable("parqueId") Long parqueId) {
        List<Aerogerador> aerogeradors = aerogeradorRepository.findByParqueEolicoId(parqueId);
        if (aerogeradors.isEmpty()) throw new NotFoundException("Aerogeradores não encontrados");
        return new ResponseEntity<>(aerogeradors, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna todos um aerogerador de um parque eólico")
    @GetMapping(value = "parques-eolicos/{parqueId}/aerogeradores/{aeroId}")
    public ResponseEntity readAerogerador(
            @PathVariable("parqueId") Long parqueId,
            @PathVariable("aeroId") Long aeroId ) {
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(parqueId);
        if (!parqueEolico.isPresent()) return new ResponseEntity (HttpStatus.NOT_FOUND);
        Optional<Aerogerador> aerogerador = aerogeradorRepository.findById(aeroId);
        if (!aerogerador.isPresent()) throw new NotFoundException("Aerogerador não encontrado");
        return new ResponseEntity<>(aerogerador, HttpStatus.OK);
    }

    @ApiOperation(value = "Cadastra um aerogerador")
    @PostMapping (value = "parques-eolicos/{parqueId}/aerogeradores")
    public ResponseEntity createAerogerador(
            @PathVariable("parqueId") Long parqueId,
            @Valid @RequestBody Aerogerador body) {
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(parqueId);
        if (!parqueEolico.isPresent()) return new ResponseEntity (HttpStatus.NOT_FOUND);
        body.setParqueEolico(parqueEolico.get());
        Aerogerador aerogerador = aerogeradorRepository.save(body);
        return new ResponseEntity<>(aerogerador, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Modifica um aerogerador")
    @PutMapping (value = "parques-eolicos/{parqueId}/aerogeradores/{aeroId}")
    public ResponseEntity updateAerogerador(
            @PathVariable("parqueId") Long parqueId,
            @PathVariable("aeroId") Long aeroId,
            @Valid @RequestBody Aerogerador body) {
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(parqueId);
        if (!parqueEolico.isPresent()) throw new NotFoundException("Parque eólico não encontrado");
        Optional<Aerogerador> aerogerador = aerogeradorRepository.findById(aeroId);
        if (!aerogerador.isPresent()) throw new NotFoundException("Aerogerador não encontrado");
        aerogerador.get().setNome(body.getNome());
        aerogerador.get().setLatitude(body.getLatitude());
        aerogerador.get().setLongitude(body.getLongitude());
        aerogerador.get().setAlturaTorre(body.getAlturaTorre());
        aerogerador.get().setModelo(body.getModelo());
        aerogerador.get().setLongitude(body.getLongitude());

        aerogeradorRepository.save(aerogerador.get());
        return new ResponseEntity<>(aerogerador, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Remove um aerogerador")
    @DeleteMapping (value = "parques-eolicos/{parqueId}/aerogeradores/{aeroId}")
    public ResponseEntity deleteAerogerador(
            @PathVariable("parqueId") Long parqueId,
            @PathVariable("aeroId") Long aeroId) {
        Optional<ParqueEolico> parqueEolico = parqueEolicoRepository.findById(parqueId);
        if (!parqueEolico.isPresent()) throw new NotFoundException("Parque eólico não encontrado");
        Optional<Aerogerador> aerogerador = aerogeradorRepository.findById(aeroId);
        if (!aerogerador.isPresent()) throw new NotFoundException("Aerogerador não encontrado");
        aerogeradorRepository.deleteById(aeroId);
        return new ResponseEntity (HttpStatus.NO_CONTENT);
    }

}
