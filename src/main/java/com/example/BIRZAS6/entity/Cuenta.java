package com.example.BIRZAS6.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;

@Entity
@Table(name="cuentas")
public class Cuenta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codcue")
    private Integer codcue;

    @Column(name = "descue", nullable=true,length=50)
    private String descue;

    @Column(name = "titcue", nullable=false,length=50)
    private String titcue;

    // Relacionando Tablas
    // Banco
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codban")
    @JsonProperty(access = Access.WRITE_ONLY)
    Banco banco;

    // Moneda
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codmon")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Moneda moneda;

    public Cuenta() {
    }

    public Integer getCodcue() {
        return codcue;
    }

    public void setCodcue(Integer codcue) {
        this.codcue = codcue;
    }

    public String getDescue() {
        return descue;
    }

    public void setDescue(String descue) {
        this.descue = descue;
    }

    public String getTitcue() {
        return titcue;
    }

    public void setTitcue(String titcue) {
        this.titcue = titcue;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    
    

}
