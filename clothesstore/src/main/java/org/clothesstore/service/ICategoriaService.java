package org.clothesstore.service;

import org.clothesstore.excepciones.DuplicateKeyException;
import org.clothesstore.excepciones.ResourceNotFoundException;
import org.clothesstore.model.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICategoriaService {
	
	public Page<Categoria> getCategorias(Pageable pageable);
	public Categoria getCategoria(int id)  throws ResourceNotFoundException;
	public Categoria crearCategoria(Categoria categoria) throws DuplicateKeyException;
	public Categoria actualizarCategoria(Categoria categoria) throws ResourceNotFoundException;
	public String eliminarCategoria(int id) throws ResourceNotFoundException;
}
