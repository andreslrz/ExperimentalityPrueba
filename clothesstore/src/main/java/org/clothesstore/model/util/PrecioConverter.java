package org.clothesstore.model.util;

import org.clothesstore.model.dto.PrecioProductoDTO;
import org.clothesstore.model.entity.PrecioProducto;
import org.clothesstore.model.entity.Producto;

import lombok.Builder;

@Builder
public class PrecioConverter {
	
	public PrecioProducto getPrecio(PrecioProductoDTO precio) {
		return PrecioProducto
				.builder()
					.precio(precio.getPrecio())
					.inicioVigencia(precio.getInicioVigencia())
					.finVigencia(precio.getFinVigencia())
					.producto(Producto
								.builder()
									.id(precio.getProducto())
									.build())
					.build();
	}

}
