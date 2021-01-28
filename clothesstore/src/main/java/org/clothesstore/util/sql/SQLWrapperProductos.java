package org.clothesstore.util.sql;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class SQLWrapperProductos {
	
	public static final String SELECT_PRODUCTOS = "SELECT_PRODUCTOS";
	public static final String SELECT_PRODUCTO = "SELECT_PRODUCTO";
	public static final String SELECT_PRECIOS_VIGENTE_PRODUCTO = "SELECT_PRECIOS_VIGENTE_PRODUCTO";
	public static final String SELECT_DESCUENTOS_VIGENTE_PRODUCTO = "SELECT_DESCUENTOS_VIGENTE_PRODUCTO";
	public static final String SELECT_PRODUCTOS_POPULARES = "SELECT_PRODUCTOS_POPULARES";
	public static final String SELECT_IMAGENES = "SELECT_IMAGENES";
	
	@Resource(name = "sql")
	private Properties sql;
	
	public String getSelectProductos() {
		System.out.println(sql.getProperty(SELECT_PRODUCTOS));
		return sql.getProperty(SELECT_PRODUCTOS);
	}
	
	public String getSelectProducto() {
		return sql.getProperty(SELECT_PRODUCTO);
	}
	
	public String getSelectPreciosVigentesProducto() {
		return sql.getProperty(SELECT_PRECIOS_VIGENTE_PRODUCTO);
	}
	
	public String getSelectDescuentosVigentes() {
		return sql.getProperty(SELECT_DESCUENTOS_VIGENTE_PRODUCTO);
	}
	
	public String getSelectImagenes() {
		return sql.getProperty(SELECT_IMAGENES);
	}
	
	public String getSelectProductosPopulares() {
		return sql.getProperty(SELECT_PRODUCTOS_POPULARES);
	}
}
