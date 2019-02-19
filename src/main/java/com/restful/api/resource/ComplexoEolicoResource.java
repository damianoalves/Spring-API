package com.restful.api.resource;


import com.restful.api.service.ComplexoEolicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value="/api")
public class ComplexoEolicoResource {

    @Autowired
    ComplexoEolicoService complexoEolicoService;

}