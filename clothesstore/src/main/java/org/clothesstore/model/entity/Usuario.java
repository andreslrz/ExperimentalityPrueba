package org.clothesstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	private long id;
	
	@Column(name= "documento", length = 12, nullable=false)
	private String documento;
	
	@Column(name= "nombre1", length = 30, nullable=false)
	private String nombre1;
	
	@Column(name= "nombre2", length = 30, nullable=true)
	private String nombre2;
	
	@Column(name= "apellido1", length = 30, nullable=false)
	private String apellido1;
	
	@Column(name= "apellido2", length = 30, nullable=true)
	private String apellido2;
	
	@Column(name= "usuario", length = 30, nullable=false)
	private String usuario;
	
	@Column(name= "contrasena", length = 50, nullable=false)
	private String contrasena;
	

}
