import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  customerURL:string="http://localhost:9091/Customer";

  constructor(private h:HttpClient) { }

  getAllCustomers():Observable<any[]>{
    return this.h.get<any[]>(this.customerURL + '/viewAllCustomer');
  }
  
  addCustomer(p:Customer):Observable<any>{
    return this.h.post(this.customerURL+ '/addCustomer',p,{responseType:"text"});
  }

  modifyCustomer(p:Customer):Observable<any>{
    return this.h.put(this.customerURL + '/updateCustomer',p,{responseType:"text"});
  }

  deleteCustomer(id:number):Observable<any>{
    return this.h.delete(this.customerURL +'/deleteCustomer/'+id);
  }

  viewCustomerById(id:number):Observable<any>{
    return this.h.get<any>(this.customerURL+'/viewCustomerById/'+id);
  }

  validateCustomer(name:string,pass:string):Observable<any>{
    return this.h.get<any>(this.customerURL+'/validateCustomer/'+name+'/'+pass);
  }

 

}
