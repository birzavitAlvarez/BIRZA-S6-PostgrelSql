package com.example.BIRZAS6.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="monedas")
public class Moneda {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codmon")
    Integer codmon;

    @Column(name = "nommon", nullable=false,length=40)
    String nommon;

    // para relacionar tablas
    @OneToMany(mappedBy = "moneda", cascade = CascadeType.ALL)
	private Set<Cuenta> cuenta = new HashSet<>();

    public Moneda() {
    }

    public Integer getCodmon() {
        return codmon;
    }

    public void setCodmon(Integer codmon) {
        this.codmon = codmon;
    }

    public String getNommon() {
        return nommon;
    }

    public void setNommon(String nommon) {
        this.nommon = nommon;
    }

    public Set<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(Set<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }
    

}
