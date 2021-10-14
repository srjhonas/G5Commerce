package com.tienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.proveedor;
import com.tienda.modelo.usuario;
import com.tienda.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios") // http:localhost:8080/usuarios
public class usuarioControlador {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("")
	public String homeUsu(Model modelousu) {
		modelousu.addAttribute("usuarios", usuarioRepository.findAll());
		return "homeUsuarios";
	}
	
	@GetMapping("/createUsuario") // http:localhost:8080/usuarios/createUsuario
	public String createUsuario() {
		return "createUsuario";
	}
	
	@PostMapping("/saveusu")
	public String saveusu(usuario usuarios) {
		usuarioRepository.save(usuarios);
		return "redirect:/usuarios";
	}

	@GetMapping("/editUsuario/{cedula_usuario}") // http:localhost:8080/usuarios/editUsuario
	public String editUsuario(@PathVariable Integer cedula_usuario, Model modelousu) {
		usuario usu = usuarioRepository.getOne(cedula_usuario);
		modelousu.addAttribute("usuariose", usu);
		return "editUsuario";
	}
	
	@GetMapping("/deleteUsuario/{cedula_usuario}") // http:localhost:8080/usuarios/deleteUsuario
	public String deleteUsuario(@PathVariable Integer cedula_usuario) {
		usuario usu = usuarioRepository.getOne(cedula_usuario);
		usuarioRepository.delete(usu);
		return "redirect:/usuarios";
	}
}
