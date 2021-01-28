package org.clothesstore.service.impl;

import java.text.MessageFormat;
import java.util.Properties;

import javax.annotation.Resource;

import org.clothesstore.data.ICategoriaRepository;
import org.clothesstore.excepciones.DuplicateKeyException;
import org.clothesstore.excepciones.ResourceNotFoundException;
import org.clothesstore.model.entity.Categoria;
import org.clothesstore.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {
	
	private static final String CATEGORIA_NO_ENCONTRADA = "CATEGORIA_NO_ENCONTRADA";
	private static final String LLAVE_UNICA_DUPLICADA = "LLAVE_UNICA_DUPLICADA";
	private static final String OK = "OK";
	
	@Autowired
	private ICategoriaRepository repository;
	
	@Resource(name = "mensajes")
	private Properties mensajes;

	@Override
	public Page<Categoria> getCategorias(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Categoria getCategoria(int id) throws ResourceNotFoundException {
		return repository.findById(id)
				.filter(categoria -> categoria != null)
				.orElseThrow(() ->
					new ResourceNotFoundException(
							mensajes.getProperty(CATEGORIA_NO_ENCONTRADA)));
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) throws DuplicateKeyException {
		try {
			categoria = repository.save(categoria);
			repository.flush();
		} catch(DataIntegrityViolationException e) {
			throw new DuplicateKeyException(MessageFormat.format(mensajes.getProperty(LLAVE_UNICA_DUPLICADA), categoria.getDescripcion()));
		}
		return categoria;
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) throws ResourceNotFoundException {
		return repository.findById(categoria.getId())
				.map(object-> {
						object.setDescripcion(categoria.getDescripcion());
						return repository.save(object);
				}).orElseThrow(() ->
					new ResourceNotFoundException(
							mensajes.getProperty(CATEGORIA_NO_ENCONTRADA)));
	}

	@Override
	public String eliminarCategoria(int id)  throws ResourceNotFoundException {
		return repository.findById(id)
				.map(categoria -> {
					repository.delete(categoria);
					return OK;
				}).orElseThrow(() ->
					new ResourceNotFoundException(
							mensajes.getProperty(CATEGORIA_NO_ENCONTRADA)));
	}

}
