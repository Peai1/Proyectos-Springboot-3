import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductoListaComponent } from './producto-lista/producto-lista.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { provideHttpClient, withFetch } from '@angular/common/http';
import { AgregarProductoComponent } from './agregar-producto/agregar-producto.component';
import { FormsModule } from '@angular/forms';
import { EditarProductoComponent } from './editar-producto/editar-producto.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductoListaComponent,
    AgregarProductoComponent,
    EditarProductoComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
  ],
  providers: [
    provideClientHydration(withEventReplay()),
    provideAnimationsAsync(),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
