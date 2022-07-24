package com.cinema.app.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.app.model.Usuario;
import com.cinema.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable long id){
		Optional<Usuario> ReadUsuario = usuarioService.findById(id);
		
		if (!ReadUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ReadUsuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Usuario usuarioCreate, @PathVariable long id){
		Optional<Usuario> usuario = usuarioService.findById(id);
		
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.get().setNombre(usuarioCreate.getNombre());
		usuario.get().setApellidos(usuarioCreate.getApellidos());
		usuario.get().setTipoDeDocumento(usuarioCreate.getTipoDeDocumento());
		usuario.get().setNumeroDeDocumento(usuarioCreate.getNumeroDeDocumento());
		usuario.get().setCorreoElectronico(usuarioCreate.getCorreoElectronico());
		usuario.get().setContraseñaCorreo(usuarioCreate.getContraseñaCorreo());
		usuario.get().setContraseña(usuarioCreate.getContraseña());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		if(!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}

