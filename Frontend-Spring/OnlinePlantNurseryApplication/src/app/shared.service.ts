 import { Injectable } from '@angular/core';
import { Customer } from './Customer';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  customerLogin :Customer;
  constructor() { }

  setCustomer(c:Customer):void{
    this.customerLogin=c;

  }

  getCustomer():Customer{
    return this.customerLogin;
  }
}
