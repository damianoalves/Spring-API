package com.restful.api.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="aerogerador")
public class Aerogerador implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
