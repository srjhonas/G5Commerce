package com.tienda.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tienda.controlador.CsvControlador;
import com.tienda.modelo.producto;


@Service
public class UploadService {

	
	@Autowired
	CsvControlador saveBD = new CsvControlador();
	
	
	
	private final Logger logg = LoggerFactory.getLogger(UploadService.class);
	public List<producto> save(MultipartFile file) throws IOException {

		byte[] bytes = file.getBytes();
		Path pathy = Paths.get(file.getOriginalFilename());
		Files.write(pathy, bytes);
		BufferedReader BR = new BufferedReader(new FileReader(file.getOriginalFilename()));
		String linea = BR.readLine();
		List<producto> productos = new ArrayList<>();
		while (linea != null) {
			String[] campos = linea.split(String.valueOf(","));
			producto PRO = new producto();
			PRO.setCodigo_producto(Integer.parseInt(campos[0]));
			PRO.setNombre_producto(campos[1]);
			PRO.setNitproveedor(Integer.parseInt(campos[2]));
			PRO.setPrecio_compra(Double.parseDouble(campos[3]));
			PRO.setIvacompra(Double.parseDouble(campos[4]));
			PRO.setPrecio_venta(Double.parseDouble(campos[5]));
			productos.add(PRO);
			logg.info("Ingreso al pelo" + PRO);
			linea = BR.readLine();
			saveBD.savepro(PRO);
			
			
		}

		if (BR != null) {
			logg.info("Ingreso al pelo13");
			BR.close();
		}
		return productos;
	}

}
