package org.clothesstore.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductoPaginaDTO {
	
	private long id;
	private String nombre;
	private String descripcion;
	private int categoria;
	private double precio;
	private double descuento;
	private int stock;
	private long numeroVisitas;
	private List<ImagenProductoDTO> imagenes;
	
	public double getPrecioDescuento() {
		return precio * (1 - descuento);
	}
	
}
