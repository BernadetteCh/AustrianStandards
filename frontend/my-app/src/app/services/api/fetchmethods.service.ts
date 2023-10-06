import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FetchmethodsService {

  private baseUrl = "http://localhost:8080";
 

  constructor(private http: HttpClient) { }

  updateWarenkorb(warenkorb: {user_id:number, product_id:number, quantity:number}): Observable<any> {
    const warenkorbUrl: string = `${this.baseUrl}/warenkorb/put`;
    return this.http.put(warenkorbUrl, warenkorb);
  }

  updateTotalPrice(bestellung: {total_amount:number,user_id:number}): Observable<any> {
    const bestellungUrl: string = `${this.baseUrl}/bestellungen/totalprice`;
    return this.http.put(bestellungUrl,bestellung);
  }

  handleCustomized(): Observable<string> {
    let jwt = localStorage.getItem('jwt');
    const customizedUrl: string =`${this.baseUrl}/messages/authorized/customized`;
    if (!jwt || jwt === undefined) {
      return throwError('401');
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${jwt}`
    });

    return this.http.get(customizedUrl, { headers:headers, responseType: 'text' }).pipe(
      catchError((error: any) => {
        console.error('ERROR: ' + error);
        return throwError(error);
      })
    );
    } 

  getAllBestellungen(user_id:number): Observable<any> {
    const url: string = `${this.baseUrl}/warenkorb/allOrders/${user_id}`;
    return this.http.get(url);
  }

  getAllProductsFromWarenkorb(user_id:number): Observable<any> {
    const productWarenkorbUrl = `${this.baseUrl}/warenkorb/allOrders/${user_id}`;
    return this.http.get(productWarenkorbUrl);
  }

  getProductFromWarenkorb(product_id: number): Observable<any> {
    console.log(product_id + " PRODICTID");
    const  productWarenkorbUrl = `${this.baseUrl}/warenkorb/quantity/${product_id}`;
    return this.http.get(productWarenkorbUrl);
  }

  deleteProduct(product_id:number,user_id:number): Observable<any> {
    const url: string = `${this.baseUrl}/warenkorb/delete`;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    const body = {
      product_id: product_id,
      user_id: user_id
    };
    
    return this.http.delete(url, { headers, body: JSON.stringify(body) }).pipe(
      catchError((error: any) => {
        console.error('ERROR: ' + error);
        return throwError(error);
      })
    );
  }
}


