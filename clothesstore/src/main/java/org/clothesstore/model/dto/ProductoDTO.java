package org.clothesstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
	
	private long id;
	private int categoria;
	private String nombre;
	private String descripcion;
	private int stock;
	private boolean activo;
	private double precio;
	
	

}
