package com.cinema.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="users")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	private int numeroDeDocumento;
	private String contraseña;
	private String tipoDeDocumento;
	private String nombre;
	private String apellidos;
	@Column(name="mail", nullable=false, length=50, unique=true)
	private String correoElectronico;
	private String contraseñaCorreo;
		
	public Usuario() {
		super();
	}

	public Usuario(int numeroDeDocumento, String contraseña, String tipoDeDocumento, String nombre,
			String apellidos, String correoElectronico, String contraseñaCorreo) {
		super();
		this.numeroDeDocumento = numeroDeDocumento;
		this.contraseña = contraseña;
		this.tipoDeDocumento = tipoDeDocumento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.contraseñaCorreo = contraseñaCorreo;
	}

	public int getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	public void setNumeroDeDocumento(int numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(String tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContraseñaCorreo() {
		return contraseñaCorreo;
	}

	public void setContraseñaCorreo(String contraseñaCorreo) {
		this.contraseñaCorreo = contraseñaCorreo;
	}

	public long getId() {
		return  id;
	}

	

}
