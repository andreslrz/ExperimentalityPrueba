package org.clothesstore.controllers;

import org.clothesstore.excepciones.DuplicateKeyException;
import org.clothesstore.excepciones.ResourceNotFoundException;
import org.clothesstore.model.entity.Categoria;
import org.clothesstore.service.ICategoriaService;
import org.clothesstore.util.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class CategoriaController {
	
	@Autowired
	@Qualifier("categoriaService")
	private ICategoriaService categoriaService;
	
	@Autowired
	private ExceptionHandler handler;
	
	@GetMapping("/categorias")
	public Page<Categoria> getCategorias(Pageable pageable) {
		return categoriaService.getCategorias(pageable);
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<? extends Object> getCategoria(@PathVariable(value="id") int id) {
		Object response;
		try {
			response = categoriaService.getCategoria(id);
		} catch(ResourceNotFoundException e) {
			response = handler.buildMessage(e);
		}
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/categorias/new")
	public ResponseEntity<Object> crearCategoria(@RequestBody Categoria categoria) {
		Object response;
		try {
			response = categoriaService.crearCategoria(categoria);
		} catch(DuplicateKeyException e) {
			response = handler.buildMessage(e);
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/categorias")
	public ResponseEntity<Object> actualizarCategoria(Categoria categoria) {
		Object response;
		try {
			response = categoriaService.actualizarCategoria(categoria);
		} catch (Exception e) {
			response = handler.buildMessage(e);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/categorias/{id}")
	public String eliminarCategoria(@PathVariable(value="id") int id) {
		return null;
	}

}
