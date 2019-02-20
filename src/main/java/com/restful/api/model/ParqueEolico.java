package com.restful.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="parque_eolico")
public class ParqueEolico implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @PrimaryKeyJoinColumn
    private ComplexoEolico complexoEolico;

    @NotEmpty
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;

    private Integer latitude;

    private Integer longitude;

    @NotNull
    @Column(name = "potencia_instalada")
    private Float potenciaInstalada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComplexoEolico getComplexoEolico() {
        return complexoEolico;
    }

    public void setComplexoEolico(ComplexoEolico complexoElolico) {
        this.complexoEolico = complexoElolico;
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

    public Float getPotenciaInstalada() {
        return potenciaInstalada;
    }

    public void setPotenciaInstalada(Float potenciaInstalada) {
        this.potenciaInstalada = potenciaInstalada;
    }
}
