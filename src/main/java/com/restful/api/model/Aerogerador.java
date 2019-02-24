package com.restful.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Damiano Alves on 20/02/19
 * damiano.alves@gmail.com
 */

@Entity
@Table(name="aerogerador")
@ApiModel(value="Aerogerador", description="Modelo de dados de aerogeradores")
public class Aerogerador implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.PERSIST)
    @JoinColumn(name = "parque_eolico_id", nullable = false, foreignKey=@ForeignKey(name = "Fk_parque_eolico_id"))
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ParqueEolico parqueEolico;

    @NotEmpty
    @Size(max = 45)
    @Column(name = "nome")
    @ApiModelProperty(required = true)
    private String nome;

    private Float latitude;

    private Float longitude;

    private Float alturaTorre;

    private Float diametroVarredura;

    @NotEmpty
    @Size(max = 45)
    @ApiModelProperty(required = true)
    private String modelo;

    public Aerogerador() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParqueEolico getParqueEolico() {
        return parqueEolico;
    }

    public void setParqueEolico(ParqueEolico parqueEolico) {
        this.parqueEolico = parqueEolico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getAlturaTorre() {
        return alturaTorre;
    }

    public void setAlturaTorre(Float alturaTorre) {
        this.alturaTorre = alturaTorre;
    }

    public Float getDiametroVarredura() {
        return diametroVarredura;
    }

    public void setDiametroVarredura(Float diametroVarredura) {
        this.diametroVarredura = diametroVarredura;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
