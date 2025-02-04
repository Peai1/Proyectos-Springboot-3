package pipe.inventarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pipe.inventarios.model.Producto;
import pipe.inventarios.repository.ProductoRepositorio;

@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepositorio.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Integer idProducto) {
        return this.productoRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepositorio.save(producto);
        // se hace update si el id ya existe o se crea si no existe
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }

}
