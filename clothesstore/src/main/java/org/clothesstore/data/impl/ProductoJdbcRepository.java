package org.clothesstore.data.impl;

import java.time.LocalDate;
import java.util.List;

import org.clothesstore.data.IProductoJdbcRespository;
import org.clothesstore.model.dto.ImagenProductoDTO;
import org.clothesstore.model.dto.PrecioProductoDTO;
import org.clothesstore.model.dto.ProductoPaginaDTO;
import org.clothesstore.util.sql.SQLWrapperProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoJdbcRepository implements IProductoJdbcRespository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SQLWrapperProductos wraper;

	@SuppressWarnings("deprecation")
	@Override
	public List<ProductoPaginaDTO> getProductosPorCategoria(int limit, int offset, int categoria) {
		return jdbcTemplate.query(wraper.getSelectProductos(), new Object[] { categoria, limit, offset },
				(rs, rowNum) -> new ProductoPaginaDTO(rs.getLong("id"), rs.getString("nombre"),
						rs.getString("descripcion"), categoria, rs.getDouble("precio"), rs.getDouble("descuento"),
						rs.getInt("stock"), 0, null));
	}

	@SuppressWarnings("deprecation")
	@Override
	public ProductoPaginaDTO getProducto(long id) {
		return jdbcTemplate.queryForObject(wraper.getSelectProducto(), new Object[] { id },
				(rs, rowNum) -> new ProductoPaginaDTO(rs.getLong("id"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getInt("categoria"), rs.getDouble("precio"),
						rs.getDouble("descuento"), rs.getInt("stock"), rs.getLong("numero_visitas"), null));
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PrecioProductoDTO> buscarPreciosVigentes(LocalDate fecha, long producto) {
		return jdbcTemplate.query(wraper.getSelectPreciosVigentesProducto(),
				new Object[] { producto, fecha.toString() },
				(rs, rowNum) -> PrecioProductoDTO.builder().id(rs.getLong("id")).build());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Long> buscarDescuentosVigentes(LocalDate fecha, long producto) {
		return jdbcTemplate.queryForList(wraper.getSelectPreciosVigentesProducto(),
				new Object[] { producto, fecha.toString() }, Long.class);
	}

	@Override
	public List<ProductoPaginaDTO> getProductosPopulares() {
		return jdbcTemplate.query(wraper.getSelectProductosPopulares(),
				(rs, rowNum) -> new ProductoPaginaDTO(rs.getLong("id"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getInt("categoria"), rs.getDouble("precio"),
						rs.getDouble("descuento"), rs.getInt("stock"), rs.getLong("numero_visitas"), null));
	}
	
	public List<ImagenProductoDTO> getImagenes(long id) {
		return jdbcTemplate.query(wraper.getSelectImagenes(),
				new Object[] { id },
				(rs, rowNum) -> ImagenProductoDTO.builder().id(rs.getLong("id")).ruta(rs.getString("ruta")).build());
	}

}
