package com.senai.apivsconnect.models;

public enum TipoModel {

    //opçoes da lista
    ADMIN("admin"), //tipo 0
    DESENVOLVEDOR("dev"), // tipo 1

    CLIENTE("cliente"); // tipo 2


    //atributos
    private String tipo;

    //metodos construtor = qnd chamar um tipo model em algum lugar sempre tem que passar uma informaçao
    //ex TipoModel sempre receber uma String, deve ser salvo dentro do atributo da classe tipo

    TipoModel(String tipoRecebido){
        this.tipo = tipoRecebido;
    }

    public String getRole(){
        return tipo;
    }


}
