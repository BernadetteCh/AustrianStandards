import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../services/api/security/register.service';
//import {RegisterService} from '../services/register.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{
firstname:string='';
email:string='';
password:string='';

constructor(private service: RegisterService, private router: Router){}

onSubmit():void {
 this.service.registerUser({firstName:this.firstname,email:this.email,password:this.password})
 .subscribe({next: (data) => {
  if (data == 201) {
    // Route to the 'success' route
    this.router.navigate(['/login']);
  }
 },
error: (error:HttpErrorResponse): void => {
  if(error instanceof ErrorEvent) {
  }else {
    console.log(error.error.status);
    console.log(error.error.message);
  }
}})
}

  


}
