package com.restful.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Damiano Alves on 20/02/19
 * damiano.alves@gmail.com
 */

@Entity
@Table(name="complexo_eolico")
@ApiModel(value="Complexo Eolico", description="Modelo de dados de complexo eólico")
public class ComplexoEolico implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;

    @NotEmpty
    @Size(max = 45)
    @Column(name = "uf")
    private String uf;

    @NotEmpty
    @Size(max = 45)
    @Column(name = "identificador")
    private String identificador;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "complexoEolico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ParqueEolico> parqueEolicos;

    public ComplexoEolico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Set<ParqueEolico> getParqueEolicos() {
        return parqueEolicos;
    }

    public void setParqueEolicos(Set<ParqueEolico> parqueEolicos) {
        this.parqueEolicos = parqueEolicos;
    }
}