package com.senai.apivolksway.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Stack;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)

    private UUID id;

    public String nome;

    private String telefone;

    protected String email;
    @JsonIgnore
    private String senha;

    public String dataNascimento;

    public String cidade;

    public String cpf;

    public Integer tipoUsaurio;
}
