package org.clothesstore.model.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.clothesstore.model.dto.ProductoDTO;
import org.clothesstore.model.dto.ProductoPaginaDTO;
import org.clothesstore.model.entity.Categoria;
import org.clothesstore.model.entity.PrecioProducto;
import org.clothesstore.model.entity.Producto;

import lombok.Builder;

@Builder
public class ProductoConverter {
	
	public Producto getEntity(ProductoDTO producto) {
		return Producto
				.builder()
				.categoria(Categoria
						.builder()
						.id(producto.getCategoria())
						.build())
				.nombre(producto.getNombre())
				.descripcion(producto.getDescripcion())
				.stock(producto.getStock())
				.activo(producto.isActivo())
				.fechaCreacion(LocalDateTime.now())
				.build();
	}
	
	public Producto getEntity(ProductoPaginaDTO producto) {
		return Producto
				.builder()
				.categoria(Categoria
						.builder()
						.id(producto.getCategoria())
						.build())
				.id(producto.getId())
				.nombre(producto.getNombre())
				.descripcion(producto.getDescripcion())
				.stock(producto.getStock())
				.activo(Boolean.TRUE)
				.fechaCreacion(LocalDateTime.now())
				.numeroVisitas(producto.getNumeroVisitas())
				.build();
	}
	
	
	public PrecioProducto getPrecioEntity(ProductoDTO producto) {
		return PrecioProducto
				.builder()
				.precio(producto.getPrecio())
				.inicioVigencia(LocalDate.now())
				.finVigencia(LocalDate.of(9999, 12, 31))
				.build();
	}

}
