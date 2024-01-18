import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './Order';

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {

  orderURL:string="http://localhost:9091/order";

  constructor(private h:HttpClient) { }

  getAllOrders():Observable<any[]>{
    return this.h.get<any[]>(this.orderURL +'/viewAll');
  }
  
  addOrder(p:Order):Observable<any>{
    return this.h.post(this.orderURL+'/add',p,{responseType:"text"});
  }

  modifyOrder(p:Order):Observable<any>{
    return this.h.put(this.orderURL+'/update',p,{responseType:"text"});
  }

  deleteOrder(id:number):Observable<any>{
    return this.h.delete(this.orderURL +'/delete/'+id);
  }

  viewOrderById(id:number):Observable<any>{
    return this.h.get<any>(this.orderURL+'/viewById/'+id);
  }

  
}
