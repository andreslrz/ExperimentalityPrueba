package org.clothesstore.controllers;

import java.util.List;

import org.clothesstore.excepciones.DuplicateKeyException;
import org.clothesstore.model.dto.DescuentoProductoDTO;
import org.clothesstore.model.dto.PrecioProductoDTO;
import org.clothesstore.model.dto.ProductoDTO;
import org.clothesstore.model.dto.ProductoPaginaDTO;
import org.clothesstore.service.IProductoService;
import org.clothesstore.util.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	private ExceptionHandler handler;

	@GetMapping("/producto/{categoria}/{limit}/{offset}")
	public List<ProductoPaginaDTO> getProductos(@PathVariable(value ="categoria") int categoria, @PathVariable(value ="limit") int limit, @PathVariable(value ="offset") int offset) {
		return productoService.getProductosCategoria(categoria, limit, offset);
	}
	
	
	@GetMapping("/producto/detalle/{id}")
	public ResponseEntity<? extends Object> getProducto(@PathVariable(value="id") long id) {
		Object response = null;
		try {
			response = productoService.getProducto(id);
		} catch (Exception e) {
			e.printStackTrace();
			response = handler.buildMessage(e);
		}
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/producto/populares")
	public List<ProductoPaginaDTO> getProductosPopulares() {
		return productoService.getProductosPopulares();
	}
	
	@PostMapping("/producto/nuevo")
	public ResponseEntity<? extends Object> crearProducto(@RequestBody ProductoDTO producto) {
		Object response = null;
		try {
			response = productoService.crearProducto(producto);
		} catch (DuplicateKeyException e) {
			response = handler.buildMessage(e);
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/producto/eliminar/{id}")
	public ResponseEntity<? extends Object> eliminarProducto(@PathVariable(value="id") long id) {
		Object response;
		try {
			response = productoService.eliminarProducto(id);
		} catch (Exception e) {
			response = handler.buildMessage(e);
		}
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/producto/precio")
	public PrecioProductoDTO actualizarPrecioProducto(@RequestBody PrecioProductoDTO precio) {
		return productoService.actualizarPrecioProducto(precio);
	}
	
	@PostMapping("/producto/descuento")
	public DescuentoProductoDTO crearDescuento(DescuentoProductoDTO descuento) {
		return productoService.crearDescuento(descuento);
	}
	
	@PutMapping("/producto/decuento/{id}")
	public ResponseEntity<? extends Object> anularDescuento(@PathVariable("id") long id) {
		Object result;
		try {
			result = productoService.anularDescuento(id);
		} catch (Exception e) {
			result = handler.buildMessage(e);
		}
		return ResponseEntity.ok(result);
	}
	
}
