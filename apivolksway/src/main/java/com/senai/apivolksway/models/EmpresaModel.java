package com.senai.apivolksway.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "tb_empresas")
public class EmpresaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa", nullable = false)
    private UUID id;

    private String razaoSocial;
    private String cidade;

    private String cnpj;
}
