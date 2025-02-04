package pipe.inventarios.service;

import java.util.List;

import pipe.inventarios.model.Producto;

public interface IProductoServicio {
    public List<Producto> listarProductos();

    public Producto obtenerProductoPorId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProducto(Integer idProducto);
}
