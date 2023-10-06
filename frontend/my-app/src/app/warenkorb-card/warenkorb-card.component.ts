import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FetchmethodsService } from '../services/api/fetchmethods.service';
import { HttpErrorResponse } from '@angular/common/http';
import { SharedServiceService } from '../services/shared-service.service';

@Component({
  selector: 'app-warenkorb-card',
  templateUrl: './warenkorb-card.component.html',
  styleUrls: ['./warenkorb-card.component.css']
})
export class WarenkorbCardComponent {

@Input()
warenkorbProductData: any

@Input()
index: number = -1;

@Output()
delete: EventEmitter<number> = new EventEmitter<number>();

price: number = 0;
constructor(private fetchmethodsService: FetchmethodsService, private sharedService: SharedServiceService){}

onDelete(product_id: number, currentPrice:number): void {
  console.log(product_id + " PRODUCTID! ")
  const user_id:number = 1;

 
  //get all products from warenkorb, to save actual price
    this.fetchmethodsService.getAllProductsFromWarenkorb(user_id)
    .subscribe({next: (data)=> {
    for (let i = 0; i < data.length; i++) {
      if(product_id === data[i].id) {
      this.price = data[i].price
      }
    }   
    },
    error:(error:HttpErrorResponse): void =>{
      if(error instanceof ErrorEvent) {
      }else {
        console.log(error.error.status);
        console.log(error.error.message);
      }
    }
  });

//get quantitiy of product what user wants to delete and delete product from databank
  this.fetchmethodsService.getProductFromWarenkorb(product_id)
.subscribe(({next: (data)=> {
  const quantity: number = data;
  this.sharedService.decreaseTotaPriceWhenProductGetsRemoved( currentPrice * quantity);
},error:(error:HttpErrorResponse): void =>{
  if(error instanceof ErrorEvent) {
  }else {
    console.log(error.error.status);
    console.log(error.error.message);
  }
}
}));

  //delete Product from Warenkorb
  this.delete.emit(this.index);
  this.fetchmethodsService.deleteProduct(product_id, user_id).subscribe(
    (response) => {
      console.log('Response: ' + response);
    },
    (error: any) => {
      console.error('Error: ' + error);
    });
}
}
