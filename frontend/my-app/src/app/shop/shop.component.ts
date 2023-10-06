import { Component, OnInit } from '@angular/core';
import { ShopService } from '../services/api/shop.service';
import { HttpErrorResponse } from '@angular/common/http';
import { GlobalDataService } from '../services/global-data.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  products: Array<any> = [];
  amount: any; 

  totalPrice: number = 0;
  constructor(private service: ShopService, private globalDataService: GlobalDataService){}

  updateAmount(price: number): void {
    console.log(price);
    /* this.amount = this.globalDataService.getAmount();
     console.log(this.amount);
     return this.amount;*/
  }
  
  ngOnInit(): void {
    this.service.getAllProducts().subscribe({next: (data) => {
      console.log(data);
      this.products = data;
    }, error: (error: HttpErrorResponse): void => {
      if(error instanceof ErrorEvent) {
      }else {
        console.log(error.error.status);
        console.log(error.error.message);
      }
    }})
  }

  }

