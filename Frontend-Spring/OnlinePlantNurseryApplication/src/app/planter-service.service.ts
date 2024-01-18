import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Planter } from './Planter';

@Injectable({
  providedIn: 'root'
})
export class PlanterServiceService {

  planterURL:string="http://localhost:9091/planter";

  constructor(private h:HttpClient) { }

  getAllPlanters():Observable<any[]>{
    return this.h.get<any[]>(this.planterURL + '/viewAll');
  }
  
  addPlanter(p:Planter):Observable<any>{
    return this.h.post(this.planterURL+'/add',p,{responseType:"text"});
  }

  modifyPlanter(p:Planter):Observable<any>{
    return this.h.put(this.planterURL +'/update',p,{responseType:"text"});
  }

  deletePlanter(id:number):Observable<any>{
    return this.h.delete(this.planterURL +'/delete/'+id);
  }

  viewPlanterById(id:number):Observable<any>{
    return this.h.get<any>(this.planterURL+'/viewById/'+id);
  }

  viewByPlanterShape(name:string):Observable<any>{
    return this.h.get<any>(this.planterURL+'/viewByName/'+name);
  }

  viewPlanterInRange(min:number,max:number):Observable<any[]>{
    return this.h.get<any[]>(this.planterURL+'/viewAll/'+min+'/'+max);
  }

}