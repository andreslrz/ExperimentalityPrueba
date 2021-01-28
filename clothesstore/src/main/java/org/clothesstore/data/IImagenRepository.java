package org.clothesstore.data;

import org.clothesstore.model.entity.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagenRepository extends JpaRepository<ImagenProducto, Long> {

}
