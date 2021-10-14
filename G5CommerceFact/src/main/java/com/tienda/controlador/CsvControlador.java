package com.tienda.controlador;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda.modelo.producto;
import com.tienda.repository.ProductoRepository;
import com.tienda.service.UploadService;

@Controller
public class CsvControlador {
	@Autowired
	private UploadService upload;
	@Autowired
	private ProductoRepository productoRepository;
	

	@GetMapping("/csv")
	public String homecsv() {
		return "homeCSV";
	}
	
	@PostMapping("/cargarcsv")
	public String carga(@RequestParam ("archivo") MultipartFile file, RedirectAttributes ms) {
		try {
			upload.save(file);
			
			ms.addFlashAttribute("mensaje", "Archivo Guardado y Cargado a la Base de Datos Correctamente");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/csv";
		
	}
	
	@PostMapping("/savepro")
	public String savepro(producto productos) {
		productoRepository.save(productos);
		return "redirect:/csv";
	}
	

}
