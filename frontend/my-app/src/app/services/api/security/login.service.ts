import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  loginUser(email:string, password: string) {
    const auth = btoa(`${email}:${password}`);
    const headers = new HttpHeaders({
      'Authorization': `Basic ${auth}`
    });

    return this.http.get(`${this.baseUrl}/login`, { headers: headers, responseType: 'text' })
      .toPromise()
      .then((jwt) => {
        return jwt;
      })
      .catch((error) => {
        console.log("ERROR: " + error);
        throw error;
      });
  }
}
