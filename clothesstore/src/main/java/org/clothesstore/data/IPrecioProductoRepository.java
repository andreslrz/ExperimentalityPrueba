package org.clothesstore.data;

import java.time.LocalDate;
import java.util.List;

import org.clothesstore.model.entity.PrecioProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrecioProductoRepository extends JpaRepository<PrecioProducto, Long> {
	
	@Query("SELECT u FROM PrecioProducto u WHERE u.producto = :producto")
	public List<PrecioProducto> findByProducto(@Param("producto") long producto);
	
	@Query("SELECT u FROM PrecioProducto u WHERE :fecha BETWEEN u.inicioVigencia AND u.finVigencia AND u.producto = :producto")
	public List<PrecioProducto> findByRangoFecha(@Param("fecha") LocalDate fecha, @Param("producto") Long producto);

}
