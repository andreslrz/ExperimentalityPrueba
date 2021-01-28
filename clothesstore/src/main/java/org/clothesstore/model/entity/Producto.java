package org.clothesstore.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name="tb_producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="numero_visitas", nullable=false)
	private long numeroVisitas;
	
	@Column(name = "nombre", unique=true, length=30, nullable=false)
	private String nombre;
	
	@Column(name = "descripcion", unique=false, length=500, nullable=true)
	private String descripcion;
	
	@Column(name="fecha_creacion", columnDefinition="DATE", nullable=false)
	private LocalDateTime fechaCreacion;
	
	@Column(name="stock", nullable=false)
	private int stock;
	
	@Column(name="activo", nullable=false)
	private boolean activo;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoria", nullable=false)
	private Categoria categoria;
	
	@OneToMany(mappedBy="producto")
	private List<PrecioProducto> preciosProducto;
	
	@OneToMany(mappedBy="producto")
	private List<DescuentoProducto> descuentosProducto;
	
	@OneToMany(mappedBy="producto")
	private List<ImagenProducto> imagenes;
	
	
	

}
