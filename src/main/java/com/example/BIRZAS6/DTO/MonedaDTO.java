package com.example.BIRZAS6.DTO;

public class MonedaDTO {
    
    private Integer codmon;
    private String nommon;

    public MonedaDTO() {
    }

    public MonedaDTO(Integer codmon, String nommon) {
        this.codmon = codmon;
        this.nommon = nommon;
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

}
