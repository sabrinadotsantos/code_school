package com.senai.apivolksway.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_checklists")
public class ChecklistModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_checklists", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo")
    private VeiculoModel veiculo;

    public Boolean ar_condicionado;

    public  Boolean freio;

    public Boolean combustivel;

    public  Boolean documentos;

    public Boolean oleo;

    public String foto_pneu;


}
