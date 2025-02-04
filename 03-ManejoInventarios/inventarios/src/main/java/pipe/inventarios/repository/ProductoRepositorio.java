package pipe.inventarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pipe.inventarios.model.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

}
