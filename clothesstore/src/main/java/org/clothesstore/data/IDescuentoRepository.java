package org.clothesstore.data;

import org.clothesstore.model.entity.DescuentoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDescuentoRepository extends JpaRepository<DescuentoProducto, Long> {

}
