package org.clothesstore.data;

import org.clothesstore.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
