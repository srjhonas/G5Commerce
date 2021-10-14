package com.tienda.modelo;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "usuarios")
public class usuario {
	@Id
	private Integer cedula_usuario; 
	private String email_usuario; 
	private String nombre_usuario; 
	private String password; 
	private String tipo_usuario;
	public usuario() {
		super();
	}
	public usuario(Integer cedula_usuario, String email_usuario, String nombre_usuario, String password,
			String tipo_usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.tipo_usuario = tipo_usuario;
	}
	public Integer getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Integer cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	@Override
	public String toString() {
		return "usuario [cedula_usuario=" + cedula_usuario + ", email_usuario=" + email_usuario + ", nombre_usuario="
				+ nombre_usuario + ", password=" + password + ", tipo_usuario=" + tipo_usuario + "]";
	}
	
	

}
