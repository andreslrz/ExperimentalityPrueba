package org.clothesstore.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
	private int id;
	
	@Column(name="descripcion", length=30, nullable=false, unique=true)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos;

}
