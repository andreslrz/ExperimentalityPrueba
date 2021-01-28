package org.clothesstore.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.clothesstore.data.IDescuentoRepository;
import org.clothesstore.data.IPrecioProductoRepository;
import org.clothesstore.data.IProductoJdbcRespository;
import org.clothesstore.data.IProductoRepository;
import org.clothesstore.data.IImagenRepository;
import org.clothesstore.excepciones.DuplicateKeyException;
import org.clothesstore.excepciones.ResourceNotFoundException;
import org.clothesstore.model.dto.DescuentoProductoDTO;
import org.clothesstore.model.dto.ImagenProductoDTO;
import org.clothesstore.model.dto.PrecioProductoDTO;
import org.clothesstore.model.dto.ProductoDTO;
import org.clothesstore.model.dto.ProductoPaginaDTO;
import org.clothesstore.model.entity.DescuentoProducto;
import org.clothesstore.model.entity.ImagenProducto;
import org.clothesstore.model.entity.PrecioProducto;
import org.clothesstore.model.entity.Producto;
import org.clothesstore.model.util.DescuentoConverter;
import org.clothesstore.model.util.PrecioConverter;
import org.clothesstore.model.util.ProductoConverter;
import org.clothesstore.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	@Qualifier("productoJdbcRepository")
	private IProductoJdbcRespository jdbcRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IPrecioProductoRepository precioRepository;
	
	@Autowired
	private IDescuentoRepository descuentoRepository;
	
	@Autowired
	private IImagenRepository imagenRepository;
	

	@Override
	public List<ProductoPaginaDTO> getProductosCategoria(int categoria, int limit, int offset) {
		return jdbcRepository.getProductosPorCategoria(limit, offset, categoria);
	}

	@Override
	public ProductoPaginaDTO getProducto(long id) {
		ProductoPaginaDTO producto = jdbcRepository.getProducto(id);
		List<ImagenProductoDTO> imagenes = jdbcRepository.getImagenes(producto.getId());
		producto.setImagenes(imagenes);
		actualizarRankingProducto(producto);		
		return producto;
	}
	
	private void actualizarRankingProducto(ProductoPaginaDTO producto) {
		ProductoConverter converter = ProductoConverter.builder().build();
		Producto entity = converter.getEntity(producto);
		entity.setNumeroVisitas(entity.getNumeroVisitas() + 1L);
		System.out.println(entity.toString());
		productoRepository.save(entity);
		productoRepository.flush();
	}

	@Override
	public List<ProductoPaginaDTO> getProductosPopulares() {
		return jdbcRepository.getProductosPopulares();
	}

	@Override
	public ProductoDTO crearProducto(ProductoDTO producto) throws DuplicateKeyException {
		try {
			ProductoConverter converter = ProductoConverter.builder().build();
			Producto entity = converter.getEntity(producto);
			entity = productoRepository.save(entity);
			producto.setId(entity.getId());
			PrecioProducto precio = converter.getPrecioEntity(producto);
			precio.setProducto(entity);
			precioRepository.save(precio);
			precioRepository.flush();
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DuplicateKeyException(e.getMessage(), e);
		}
		return producto;
	}

	@Override
	public boolean eliminarProducto(long id) throws ResourceNotFoundException {
		Producto producto = productoRepository
					.findById(id)
					.map(p -> {
						p.setActivo(Boolean.FALSE);
						productoRepository.save(p);
						return p;
					})
					.orElseThrow(() -> new ResourceNotFoundException());
		return (!producto.isActivo());
	}

	@Override
	public PrecioProductoDTO actualizarPrecioProducto(PrecioProductoDTO precio) {
		PrecioConverter converter = PrecioConverter.builder().build();
		PrecioProducto entity = converter.getPrecio(precio);
		List<PrecioProductoDTO> precios =  jdbcRepository.buscarPreciosVigentes(precio.getInicioVigencia(), precio.getProducto());
		entity = precioRepository.save(entity);
		precios.forEach(p -> 
			precioRepository.findById(p.getId())
						.map(prec-> {
							prec.setFinVigencia(precio.getFinVigencia().minusDays(1L));
							precioRepository.save(prec);
							return prec;
						})
			
		);
		precio.setId(entity.getId());
		return precio;
	}

	@Override
	public DescuentoProductoDTO crearDescuento(DescuentoProductoDTO descuento) {
		DescuentoConverter converter = DescuentoConverter.builder().build();
		DescuentoProducto entity = converter.getEntity(descuento);
		List<Long> idsDescuentos = jdbcRepository.buscarDescuentosVigentes(descuento.getInicioVigencia(), descuento.getProducto());
		descuentoRepository.save(entity);
		idsDescuentos.forEach(id -> 
			descuentoRepository.findById(id).map(desc -> {
				desc.setFinVigencia(descuento.getInicioVigencia().minusDays(1L));
				descuentoRepository.save(desc);
				return desc;
			})
		);
		descuento.setId(entity.getId());
		return descuento;
	}

	@Override
	public boolean guardarImagen(ImagenProducto imagen) {
		productoRepository.findById(imagen.getProducto().getId())
			.map(prod -> {
				imagen.setProducto(prod);
				imagenRepository.save(imagen);
				return prod;
			});
		return true;
	}

	@Override
	public boolean anularDescuento(long id) throws ResourceNotFoundException {
		DescuentoProducto entity = descuentoRepository
				.findById(id).map(desc -> {
					desc.setFinVigencia(LocalDate.now().minusDays(1L));
					descuentoRepository.save(desc);
					return desc;
				}).orElseThrow(() -> new ResourceNotFoundException("No se encontro el descuento con ID: " + id));
		return entity!= null;
	}

}
