package org.clothesstore.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.clothesstore.model.entity.ImagenProducto;
import org.clothesstore.model.entity.Producto;
import org.clothesstore.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/store")
public class FileUploadController {

	@Value("${file.upload.dir}")
	private String FILE_DIRECTORY;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService service;

	@PostMapping("/producto/{name}/{id}")
	public void fileUpload(@RequestParam("File") MultipartFile file,
			@PathVariable("name") String nombre,
			@PathVariable("id") long id) throws IOException {
		String ruta = FILE_DIRECTORY + file.getOriginalFilename();
		File img = new File(ruta);
		ImagenProducto imagen = ImagenProducto
				.builder()
				.ruta(ruta)
				.producto(Producto
							.builder()
							.id(id)
							.build())
				.build();
		service.guardarImagen(imagen);
		if (img.createNewFile()) {
			try (FileOutputStream fos = new FileOutputStream(img)) {
				fos.write(file.getBytes());
			}
			
		}
	}

}
