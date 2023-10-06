import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalDataService {
  static getPrice() {
    throw new Error('Method not implemented.');
  }
  globalVariable: any;
  amount: number = 0; 
  price: number = 0;

  constructor() { }
//ng vom warenkorb
setGlobalVariable(value: number): void {
  this.globalVariable = value;
}

getGlobalVariable(): any {
  return this.globalVariable;
}

setAmount(value:number): void {
  this.amount= value;
}

getAmount(): number {
  return 1;
}

setPrice(value: number): void {
  this.price = value;
}
getPrice(): number {
  return this.price;
}
}
