import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  url = 'http://localhost:8084/WebProductosREST/api/productos';

  constructor(public http: HttpClient) { }

  getRequest(url: string): Observable<any> {
    return this.http.get(url);
  }
}
