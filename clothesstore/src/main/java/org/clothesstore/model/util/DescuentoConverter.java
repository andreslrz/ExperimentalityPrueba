package org.clothesstore.model.util;

import org.clothesstore.model.dto.DescuentoProductoDTO;
import org.clothesstore.model.entity.DescuentoProducto;
import org.clothesstore.model.entity.Producto;

import lombok.Builder;

@Builder
public class DescuentoConverter {
	
	public DescuentoProducto getEntity(DescuentoProductoDTO descuento) {
		return DescuentoProducto
				.builder()
					.descuento(descuento.getDescuento())
					.inicioVigencia(descuento.getInicioVigencia())
					.finVigencia(descuento.getFinVigencia())
					.producto(Producto
								.builder()
								.id(descuento.getProducto())
								.build())
					.build();
	}

}
