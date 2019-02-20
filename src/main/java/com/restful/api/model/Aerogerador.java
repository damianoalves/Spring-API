package com.restful.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="aerogerador")
public class Aerogerador implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "parque_eolico_id")
    private Long parqueEolicoId;

    @NotEmpty
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;

    private Float latitude;

    private Float longitude;

    private Float alturaTorre;

    private Float diametroVarredura;

    @NotEmpty
    @Size(max = 45)
    private String modelo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParqueEolicoId() {
        return parqueEolicoId;
    }

    public void setParqueEolicoId(Long parqueEolicoId) {
        this.parqueEolicoId = parqueEolicoId;
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
