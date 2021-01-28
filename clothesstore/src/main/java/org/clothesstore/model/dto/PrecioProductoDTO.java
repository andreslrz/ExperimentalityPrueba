package org.clothesstore.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PrecioProductoDTO {

	private long id;

	private double precio;

	private LocalDate inicioVigencia;

	private LocalDate finVigencia;
	
	private long producto;
}
