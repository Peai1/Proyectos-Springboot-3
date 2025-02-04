import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agregar-producto',
  standalone: false,
  templateUrl: './agregar-producto.component.html',
  styleUrl: './agregar-producto.component.css'
})
export class AgregarProductoComponent {
  producto: Producto = new Producto();

  constructor(private productoService: ProductoService, private enrutador: Router) { }

  onSubmit(){
    this.guardarProducto();
  }

  guardarProducto() {
    this.productoService.agregarProducto(this.producto).subscribe({
      next: datos => {
        console.log(datos);
        this.irListaProductos();
      },
      error: error => console.log(error)
    });
}

  irListaProductos() {
    this.enrutador.navigate(['/productos']);	
  }
}
