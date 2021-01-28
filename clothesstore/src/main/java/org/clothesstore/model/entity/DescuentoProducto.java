package org.clothesstore.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity
@Table(name="tb_descuento_producto")
public class DescuentoProducto {

	@Id
	private long id;
	
	
	@Column(name="descuento", nullable=false)
	private double descuento;
	
	@Column(name="inicio_vigencia", columnDefinition="DATE", nullable=false)
	private LocalDate inicioVigencia;
	
	@Column(name="fin_vigencia", columnDefinition="DATE", nullable=false)
	private LocalDate finVigencia;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="producto", nullable=false)
	private Producto producto;
	
}
