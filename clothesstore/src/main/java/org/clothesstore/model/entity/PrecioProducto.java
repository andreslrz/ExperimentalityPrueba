package org.clothesstore.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ToString
@Builder
@Entity
@Table(name="tb_precios_producto")
public class PrecioProducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="precio", nullable=false)
	private double precio;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name="inicio_vigencia", columnDefinition="DATE", nullable=false)
	private LocalDate inicioVigencia;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name="fin_vigencia", columnDefinition="DATE", nullable=false)
	private LocalDate finVigencia;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="producto", nullable=false)
	private Producto producto;

}
