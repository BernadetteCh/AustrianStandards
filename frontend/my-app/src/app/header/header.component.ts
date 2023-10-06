import { Component, OnInit } from '@angular/core';
import { SharedServiceService } from '../services/shared-service.service';
import { FetchmethodsService } from '../services/api/fetchmethods.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent implements OnInit{
  price: number = 0;
  username:string ='';
  totalPrice: number = 0;
constructor(private sharedService: SharedServiceService, private fetchmethodsService:FetchmethodsService, private router: Router){}

getUsername(): string {
  return this.username;
}
getTotalPrice(): number {
  console.log(this.sharedService.getTotalPrice());
  return parseFloat(this.sharedService.getTotalPrice().toFixed(2));
}
 ngOnInit() {

  this.fetchmethodsService.handleCustomized().subscribe({next:(data)=> {
    console.log(data);
    this.username = data;
  }})

  // Subscribe to the amount$ observable to keep the price updated
  this.sharedService.amount$.subscribe(newAmount => {
    this.price = 3;
    return this.fetchmethodsService.updateTotalPrice({total_amount:newAmount,user_id:1})
   .subscribe({next: (data)=> {
    console.log(data);
   },
   error:(error:HttpErrorResponse): void => {
      if(error instanceof ErrorEvent) {
      }else {
        console.log(error.error.status);
        console.log(error.error.message);
      }
   }
  })
  });
}

goToWarenkorb() {
  this.router.navigate(["warenkorb"]);
}

goToShop() {
  this.router.navigate(["shop"]);
}

}
