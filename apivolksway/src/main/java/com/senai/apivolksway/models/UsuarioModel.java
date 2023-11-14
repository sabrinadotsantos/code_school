package com.senai.apivolksway.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)

    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private EmpresaModel empresa;
    private String telefone;

    protected String email;

    private String senha;

    public String data_nascimento;

    public String cidade;

    public String cpf;

    private TipoModel tipo_usuario;
    public String nome;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipo_usuario == TipoModel.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_MOTORISTA"),
                    new SimpleGrantedAuthority("ROLE_ADMFROTA"),
                    new SimpleGrantedAuthority("ROLE_PROPRIETARIO")
            );
        } else if (this.tipo_usuario == TipoModel.MOTORISTA) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_MOTORISTA")
            );

        } else if (this.tipo_usuario == TipoModel.ADMFROTA){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMFROTA")
            );
        } else if (this.tipo_usuario == TipoModel.PROPRIETARIO) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_PROPRIETARIO")
            );
        }
        return null;

    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
