package com.example.BIRZAS6.DTO;

public class BancoDTO {
    
    private Integer codban;
    private String nomban;

    public BancoDTO() {
        super();
    }

    public BancoDTO(Integer codban, String nomban) {
        super();
        this.codban = codban;
        this.nomban = nomban;
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

}
