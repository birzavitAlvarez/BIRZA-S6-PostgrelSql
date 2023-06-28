package com.example.BIRZAS6.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="bancos")
public class Banco {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codban", nullable = false)
    private Integer codban;

    @Column(name = "nomban", nullable=false,length=40)
    private String nomban;

    //Relacioanando tablas
    @OneToMany(mappedBy = "banco", cascade = CascadeType.ALL)
	private Set<Cuenta> cuenta = new HashSet<>();

    public Banco() {
    }

    public Integer getCodban() {
        return codban;
    }

    public void setCodban(Integer codban) {
        this.codban = codban;
    }

    public String getNomban() {
        return nomban;
    }

    public void setNomban(String nomban) {
        this.nomban = nomban;
    }

    public Set<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(Set<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }


    
}
