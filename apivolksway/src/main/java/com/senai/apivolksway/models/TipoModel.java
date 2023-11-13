package com.senai.apivolksway.models;

public enum TipoModel {

    ADMIN("admin"),
    MOTORISTA("motorista"),

    ADMFROTA ("admFrota"),

    PROPRIETARIO ("proprietario");

    private String tipo;

    TipoModel(String tipoRecebido) {this.tipo = tipoRecebido;}

    public String getRole() {return tipo;}

}
