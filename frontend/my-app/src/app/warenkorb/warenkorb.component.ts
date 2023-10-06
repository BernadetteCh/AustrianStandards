import { Component, OnInit } from '@angular/core';
import { FetchmethodsService } from '../services/api/fetchmethods.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-warenkorb',
  templateUrl: './warenkorb.component.html',
  styleUrls: ['./warenkorb.component.css']
})
export class WarenkorbComponent implements OnInit {
  warenkorbProducts: Array<any> =[];

  constructor(private fetchmethodsService:FetchmethodsService) {}

  ngOnInit(): void {
    this.fetchmethodsService.getAllBestellungen(1).subscribe({next: (data) => {
      this.warenkorbProducts = data;
    }, error: (error: HttpErrorResponse): void => {
      if(error instanceof ErrorEvent) {
      }else {
        console.log(error.error.status);
        console.log(error.error.message);
      }
    }})
  }

 deleteProduct(index: number): void {
    this.warenkorbProducts.splice(index,1);  
  }
}
