package pipe.inventarios.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pipe.inventarios.model.Producto;
import pipe.inventarios.service.ProductoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
//localhost:8080/front-end
@RequestMapping("front-end")
// ip del front se donde se reciben peticiones, sirve para darle permisos a la app de angular
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    // http://localhost:8080/front-end/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos:", productos.toString());
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto) {
        Producto productoGuardado = this.productoServicio.guardarProducto(producto);
        return productoGuardado;
    }
    


    
}
