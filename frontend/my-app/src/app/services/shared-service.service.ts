import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceService {
  total: number =0;
  quantitiy: number = 0;
  private totalPrice: number = 0;


  constructor() { }

  private amountSubject = new BehaviorSubject<number>(0);
  amount$: Observable<number> = this.amountSubject.asObservable();

  updateAmount(newAmount: number) {
    this.total = newAmount;
    this.amountSubject.next(newAmount);
  }

  getCurrentAmount(): number {
    return this.amountSubject.value;
  }

  getTotalPrice(): number {
    return this.totalPrice;
  }

  updateTotalPriceDecrease(price: number): void {
    this.totalPrice += price;
  }
  updateTotalPriceIncrease(price: number): void {
    this.totalPrice -= price;
  }

  decreaseTotaPriceWhenProductGetsRemoved(price: number): void {
   this.totalPrice =  this.totalPrice- price;
  }

}
