package com.restful.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="parque_eolico")
public class ParqueEolico implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id", table = "complexo_eolico")
    private Integer complexo_elolico_id;

    @NotNull
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;

    private Integer latitude;

    private Integer longitude;

    @NotNull
    private Float potencia_instalada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComplexo_elolico_id() {
        return complexo_elolico_id;
    }

    public void setComplexo_elolico_id(Integer complexo_elolico_id) {
        this.complexo_elolico_id = complexo_elolico_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Float getPotencia_instalada() {
        return potencia_instalada;
    }

    public void setPotencia_instalada(Float potencia_instalada) {
        this.potencia_instalada = potencia_instalada;
    }
}
