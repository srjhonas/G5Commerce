package com.tienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.cliente;
import com.tienda.repository.ClienteRepository;



@Controller
@RequestMapping("/clientes") // http:localhost:8080/clientes
public class clienteControlador {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("")
	public String homeCli(Model modelocli) {
		modelocli.addAttribute("clientes", clienteRepository.findAll());
		return "homeCliente";
	}
	
	@GetMapping("/createCliente") // http:localhost:8080/clientes/createCliente
	public String createCliente() {
		return "createCliente";
	}
	
	@PostMapping("/savecli")
	public String savecli(cliente clientes) {
		clienteRepository.save(clientes);
		return "redirect:/clientes";
	}
	
	@GetMapping("/editCliente/{cedula_cliente}") // http:localhost:8080/clientes/editCliente
	public String editCliente(@PathVariable Integer cedula_cliente, Model modelocli) {
		cliente cli= clienteRepository.getOne(cedula_cliente);
		modelocli.addAttribute("clientese", cli);
		return "editCliente";
	}
	
	@GetMapping("/deleteCliente/{cedula_cliente}") // http:localhost:8080/clientes/deleteCliente
	public String deleteCliente(@PathVariable Integer cedula_cliente) {
		cliente cli= clienteRepository.getOne(cedula_cliente);
		clienteRepository.delete(cli);
		return "redirect:/clientes";
	}
	

	@GetMapping("/consultaxCliente/{cedula_cliente}") // http:localhost:8080/clientes/deleteCliente
	public String consultaxCliente(@PathVariable Integer cedula_cliente) {
		cliente cli= clienteRepository.getOne(cedula_cliente);
		return "factura";
	}
	
}
