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
import com.tienda.repository.ProductoRepository;

@Controller
@RequestMapping("/productos") // http:localhost:8080/productos
public class productoControlador {
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("")
	public String homePro(Model modelopro) {
		modelopro.addAttribute("productos", productoRepository.findAll());
		return "homeProducto";
	}
	
	@GetMapping("/createProducto") // http:localhost:8080/productos/createProducto
	public String createProducto() {
		return "createProducto";
	}
	
	@PostMapping("/savepro")
	public String savepro(producto productos) {
		productoRepository.save(productos);
		return "redirect:/productos";
	}
	
	@GetMapping("/editProducto/{codigo_producto}") // http:localhost:8080/productos/editProducto
	public String editProducto(@PathVariable Integer codigo_producto, Model modelopro) {
		producto prod = productoRepository.getOne(codigo_producto);
		modelopro.addAttribute("productose", prod);
		return "editProducto";
	}
	
	@GetMapping("/deleteProducto/{codigo_producto}") // http:localhost:8080/productos/deleteProducto
	public String deleteProducto(@PathVariable Integer codigo_producto) {
		producto prod = productoRepository.getOne(codigo_producto);
		productoRepository.delete(prod);
		return "redirect:/productos";
	}

}
