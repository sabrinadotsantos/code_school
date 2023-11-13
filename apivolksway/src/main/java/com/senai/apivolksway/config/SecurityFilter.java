package com.senai.apivolksway.config;


import com.senai.apivolksway.repositories.UsuarioRepository;
import com.senai.apivolksway.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected  void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{

        if (!request.getRequestURI().equals("/login")){
            var token = (request);
            if (token != null){
                var email = tokenService.validarToken(String.valueOf(token));
                UserDetails usuario = usuarioRepository.findByEmail(email);

                var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autenticacao);
            }
        }

        filterChain.doFilter(request, response);
    }

    private String receberToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null){
            return null;
        }

        return authHeader.replace("Bearer ", "");
    }
}
