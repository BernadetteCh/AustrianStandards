import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  registerUser(user: {firstName:string, email:string, password:string}): Observable<any> {
    const registerUrl: string = `${this.baseUrl}/register`;
    return this.http.post(registerUrl, user);
  }
}
