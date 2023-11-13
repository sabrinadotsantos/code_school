package com.senai.apivolksway.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.BitSet;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_propagandas")
public class PropagandaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_propaganda", nullable = false)
    private UUID id;

//    @ManyToOne
//    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
//    private UsuarioModel usuario;

    public  String titulo;
    public   String url;
    public  String descricao;
    public  String img;
    public  String  publico_alvo;
    public LocalDate data_limite;
    public  Float  preco;
    public BitSet importancia;
    public  String  nome_tipo_propaganda;
}
