import { Component } from '@angular/core';
import { LoginService } from '../services/api/security/login.service';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email:string = "";
  password:string = "";

  constructor(private service: LoginService, private router: Router,private http: HttpClient) {}

  onSubmit() {
    this.service.loginUser(this.email,this.password).then((jwt)=> {
      console.log(jwt);
      if (jwt !== undefined) {
        localStorage.setItem("jwt", jwt);
        this.router.navigate(["shop"]);
      }else {
        console.log("jwt is undefined");  
      }  
    }).catch((error)=> {
      console.log(error);
    })
    }
  
}
