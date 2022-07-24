package com.cinema.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
