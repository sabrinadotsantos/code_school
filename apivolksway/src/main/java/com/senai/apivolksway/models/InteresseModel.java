package com.senai.apivolksway.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.BitSet;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_interesses")
public class InteresseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_interesse", nullable = false)

    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_propaganda", referencedColumnName = "id_propaganda")
    private PropagandaModel propaganda;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioModel usuario;



    private BitSet email; //meio_contato_email
}
