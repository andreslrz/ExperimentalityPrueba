package org.clothesstore.data;

import java.time.LocalDate;
import java.util.List;

import org.clothesstore.model.dto.ImagenProductoDTO;
import org.clothesstore.model.dto.PrecioProductoDTO;
import org.clothesstore.model.dto.ProductoPaginaDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoJdbcRespository {
	
	public List<ProductoPaginaDTO> getProductosPorCategoria(int limit, int offset, int categoria);
	public ProductoPaginaDTO getProducto(long id);
	public List<PrecioProductoDTO> buscarPreciosVigentes(LocalDate fecha, long producto);
	public List<Long> buscarDescuentosVigentes(LocalDate fecha, long producto);
	public List<ProductoPaginaDTO> getProductosPopulares();
	public List<ImagenProductoDTO> getImagenes(long id);

}
