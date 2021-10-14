package com.tienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.cliente;
import com.tienda.modelo.producto;
import com.tienda.modelo.usuario;
import com.tienda.modelo.venta;
import com.tienda.repository.ClienteRepository;
import com.tienda.repository.ProductoRepository;
import com.tienda.repository.UsuarioRepository;
import com.tienda.repository.VentaRepository;
import com.tienda.service.UploadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/factura") // http:localhost:8080/factura
public class ventaControlador {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private VentaRepository ventaRepository;
	
	@GetMapping("")
	public String homeFact(Model modelofact) {
		modelofact.addAttribute("Facturas", ventaRepository.findAll());
		return "homeFactura";
	}
	
	@GetMapping("/createFactura") // http:localhost:8080/usuarios/createUsuario
	public String createFactura() {
		return "createFactura";
	}
	
	@PostMapping("/savefact")
	public String savefact(venta ventas) {
		ventaRepository.save(ventas);
		return "redirect:/factura";
	}

	@GetMapping("/editfact/{codigo_venta}") // http:localhost:8080/usuarios/editUsuario
	public String editfact(@PathVariable Integer codigo_venta, Model modelofact) {
		venta fact = ventaRepository.getOne(codigo_venta);
		modelofact.addAttribute("usuariose", fact);
		return "editfact";
	}
	
	@GetMapping("/deletefact/{codigo_venta}") // http:localhost:8080/usuarios/deleteUsuario
	public String deletefact(@PathVariable Integer codigo_venta) {
		venta delfact = ventaRepository.getOne(codigo_venta);
		ventaRepository.delete(delfact);
		return "redirect:/factura";
	}
}
