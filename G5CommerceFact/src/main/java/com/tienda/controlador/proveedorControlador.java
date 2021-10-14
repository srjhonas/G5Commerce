package com.tienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.producto;
import com.tienda.modelo.proveedor;
import com.tienda.repository.ProveedorRepository;

@Controller
@RequestMapping("/proveedores") // http:localhost:8080/proveedores
public class proveedorControlador {
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("")
	public String homePro(Model modeloprov) {
		modeloprov.addAttribute("proveedores", proveedorRepository.findAll());
		return "homeProveedor";
	}
	
	@GetMapping("/createProveedor") // http:localhost:8080/proveedores/createProveedor
	public String createProveedor() {
		return "createProveedor";
	}
	
	@PostMapping("/saveprov")
	public String saveprov(proveedor proveedores) {
		proveedorRepository.save(proveedores);
		return "redirect:/proveedores";
	}

	@GetMapping("/editProveedor/{nitproveedor}") // http:localhost:8080/proveedores/editProveedor
	public String editProveedor(@PathVariable Integer nitproveedor, Model modeloprov) {
		proveedor prov = proveedorRepository.getOne(nitproveedor);
		modeloprov.addAttribute("proveedorse", prov);
		return "editProveedor";
	}
	
	@GetMapping("/deleteProveedor/{nitproveedor}") // http:localhost:8080/proveedores/deleteProveedor
	public String deleteProveedor(@PathVariable Integer nitproveedor) {
		proveedor prov = proveedorRepository.getOne(nitproveedor);
		proveedorRepository.delete(prov);
		return "redirect:/proveedores";
	}

}
