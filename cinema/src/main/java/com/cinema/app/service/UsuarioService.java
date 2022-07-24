package com.cinema.app.service;


import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cinema.app.model.Usuario;
//Git
@Service
public interface UsuarioService {
	
	public List<Usuario> findAll(); //Modified
	
	public Page<Usuario> findAll(Pageable pageable); 
	
	public Optional<Usuario> findById(long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(long id);
}