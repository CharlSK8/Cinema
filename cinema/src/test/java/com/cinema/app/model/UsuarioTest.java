package com.cinema.app.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cinema.app.repository.UsuarioRepository;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testUser() {
		Usuario usuario = new Usuario(1017267474, "charlie", "Cédula", "Charlinson", "Perez", "charlinson@gmail.com", "charlie2");
		Usuario usuarioSave = usuarioRepository.save(usuario);
		assertNotNull(usuarioSave);
		
	}
	
	@Test
	@Order(2)
	public void testGetUserId() {
		Usuario usuario = usuarioRepository.findById(1L).get();
		assertThat(usuario.getId()).isEqualTo(1L);
	}
	
	@Test
	@Order(3)
	public void testGetAllUsers() {
		List<Usuario> usuario = usuarioRepository.findAll();
		assertThat(usuario.size()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(4)
	public void testUpdateUser() {
		Usuario user = usuarioRepository.findById(1L).get();
		user.setCorreoElectronico("charlieudate@gmail.com");
		Usuario userUpdate = usuarioRepository.save(user);
		
		assertThat(userUpdate.getCorreoElectronico()).isEqualTo("charlieudate@gmail.com");
	}
	
	@Test
	@Order(5)
	public void deleteUser() {
		Usuario user = usuarioRepository.findById(1L).get();
		usuarioRepository.delete(user);
		assertThat(user);
	}


}

