package org.clothesstore.service;

import java.util.List;

import org.clothesstore.excepciones.DuplicateKeyException;
import org.clothesstore.excepciones.ResourceNotFoundException;
import org.clothesstore.model.dto.DescuentoProductoDTO;
import org.clothesstore.model.dto.PrecioProductoDTO;
import org.clothesstore.model.dto.ProductoDTO;
import org.clothesstore.model.dto.ProductoPaginaDTO;
import org.clothesstore.model.entity.ImagenProducto;
import org.springframework.stereotype.Service;

@Service
public interface IProductoService {
	
	public List<ProductoPaginaDTO> getProductosCategoria(int categoria, int limit, int offset);
	public ProductoPaginaDTO getProducto(long id);
	public List<ProductoPaginaDTO> getProductosPopulares();
	public ProductoDTO crearProducto(ProductoDTO producto) throws DuplicateKeyException;
	public boolean eliminarProducto(long id) throws ResourceNotFoundException;
	public PrecioProductoDTO actualizarPrecioProducto(PrecioProductoDTO precio);
	public DescuentoProductoDTO crearDescuento(DescuentoProductoDTO descuento);
	public boolean guardarImagen(ImagenProducto imagen);
	public boolean anularDescuento(long id) throws ResourceNotFoundException;

}
