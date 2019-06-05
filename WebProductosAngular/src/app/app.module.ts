import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { ProductoComponent } from './components/producto/producto.component';
import { ProductoPostComponent } from './components/producto-post/producto-post.component';
import {TabsModule} from 'ngx-tabset';

@NgModule({
  declarations: [
    AppComponent,
    ProductoComponent,
    ProductoPostComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    TabsModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
