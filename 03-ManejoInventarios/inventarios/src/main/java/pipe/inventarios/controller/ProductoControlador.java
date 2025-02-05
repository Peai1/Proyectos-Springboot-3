package pipe.inventarios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pipe.inventarios.exception.RecursoNoEncontradoExcepcion;
import pipe.inventarios.model.Producto;
import pipe.inventarios.service.ProductoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
//localhost:8080/front-end
@RequestMapping("inventario-app")
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

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable(value = "id") Integer productoId) {
        Producto producto = this.productoServicio.obtenerProductoPorId(productoId);

        if (producto != null)
            return ResponseEntity.ok(producto);
            
        throw new RecursoNoEncontradoExcepcion("No se encontro el producto con el id: " + productoId);
    }
    
    // path variable es un parametro que se pasa en la url
    // request body es un parametro que se pasa en el cuerpo de la peticion (el json)
    // PUT es para actualizar y POST es para crear
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable(value = "id") Integer productoId, @RequestBody Producto productoRecibido) {
        Producto productoActualizado = this.productoServicio.obtenerProductoPorId(productoId);
        if (productoActualizado == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el producto con el id: " + productoId);
        productoActualizado.setDescripcion(productoRecibido.getDescripcion());
        productoActualizado.setPrecio(productoRecibido.getPrecio());
        productoActualizado.setExistencia(productoRecibido.getExistencia());
        this.productoServicio.guardarProducto(productoActualizado);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable(value = "id") Integer productoId) {
        Producto producto = this.productoServicio.obtenerProductoPorId(productoId);
        if (producto == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el producto con el id: " + productoId);
        this.productoServicio.eliminarProducto(producto.getIdProducto());
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
