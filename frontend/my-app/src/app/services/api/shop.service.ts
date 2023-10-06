import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Productrepresentation } from 'src/app/module/product-representation';

@Injectable({
  providedIn: 'root'
})
export class ShopService {
  private baseUrl = "http://localhost:8080";
  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<any> {
    const url = `${this.baseUrl}/products`;
    return this.http.get(url);
  }
}
