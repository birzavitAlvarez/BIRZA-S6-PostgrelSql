package com.example.BIRZAS6.DTO;

public class CuentaDTO {
    
    private Integer codcue;
    private String descue;
    private String titcue;

    private Integer codban;
    private String nomban;

    private Integer codmon;
    private String nommon;

    public CuentaDTO() {
    }

    public CuentaDTO(Integer codcue, String descue, String titcue, Integer codban, String nomban, Integer codmon,
            String nommon) {
        this.codcue = codcue;
        this.descue = descue;
        this.titcue = titcue;
        this.codban = codban;
        this.nomban = nomban;
        this.codmon = codmon;
        this.nommon = nommon;
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
