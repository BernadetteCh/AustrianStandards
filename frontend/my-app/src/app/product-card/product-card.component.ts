import { Component, EventEmitter, Input, OnChanges, OnInit, Output,SimpleChanges } from '@angular/core';
import { SharedServiceService } from '../services/shared-service.service';
import { FetchmethodsService } from '../services/api/fetchmethods.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ShopComponent } from '../shop/shop.component';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent{
  @Input() 
  productData: any;
  @Input()
  index: number = 0;

  @Output()
  increase: EventEmitter<number>= new EventEmitter<number>();

  productAmount: number = 0; 
  price: any;
  currentPrice: number = 0;
  totalPrice: number = 0;
  currentProductId: number | null = null;



  constructor(private sharedService: SharedServiceService, private fetchmethodsService:FetchmethodsService, private shopService: ShopComponent){}

  increaseAmount(productPrice: any, productId:number): void {
    this.productAmount = this.productAmount + 1;
    this.sharedService.updateTotalPriceDecrease(productPrice);
   
   //send totalprice to backend to update warenkorb
    console.log(this.productAmount + " AMOUNT UPDATEWARENKORB")
    console.log(productId + " PRODCTID FROM UPDATEWARENKORB")
    this.fetchmethodsService.updateWarenkorb({user_id:1,product_id:productId,quantity:this.productAmount})
    .subscribe({next:(data)=> {
      console.log(data + "UPDATEWARENKORB");
    },
  error:(error:HttpErrorResponse): void => {
    if(error instanceof ErrorEvent) {
    }else {
      console.log(error.error.status);
      console.log(error.error.message);
    }
  }})
  }

  
  decreaseAmount(productPrice: number, productId: number): void {
    this.productAmount = this.productAmount - 1;
    this.sharedService.updateTotalPriceIncrease(productPrice);
      //send totalprice to backend to update warenkorb
      this.fetchmethodsService.updateWarenkorb({user_id:1,product_id:productId,quantity:this.productAmount})
      .subscribe({next:(data)=> {
        console.log(data);
      },
    error:(error:HttpErrorResponse): void => {
      if(error instanceof ErrorEvent) {
      }else {
        console.log(error.error.status);
        console.log(error.error.message);
      }
    }})

  }

}
