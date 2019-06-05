import { Component, OnInit } from '@angular/core';
import { ProductoService } from 'src/app/servicio/producto.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.scss']
})
export class ProductoComponent implements OnInit {

  result = {};
  resolved = false;

  constructor(public service: ProductoService) { }

  ngOnInit() {
    this.service.getRequest(this.service.url).subscribe(
      (data) => this.processData(data));
  }

  processData(data: any) {
    this.result = data;
    this.resolved = true;
  }

}
