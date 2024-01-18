import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Plant } from './Plant';

@Injectable({
  providedIn: 'root'
})
export class PlantServiceService {

  plantURL:string="http://localhost:9091/plant";

  constructor(private h:HttpClient) { }

  getAllPlants():Observable<any[]>{
    return this.h.get<any[]>(this.plantURL + '/viewAll');
  }
  
  addPlant(p:Plant):Observable<any>{
    return this.h.post(this.plantURL + '/add',p,{responseType:"text"});
  }

  modifyPlant(p:Plant):Observable<any>{
    return this.h.put(this.plantURL + '/update',p,{responseType:"text"});
  }

  deletePlant(id:number):Observable<any>{
    return this.h.delete(this.plantURL +'/delete/'+id);
  }

  viewPlantById(id:number):Observable<any>{
    return this.h.get<any>(this.plantURL+'/viewById/'+id);
  }

  viewBycommonName(name:string):Observable<any>{
    return this.h.get<any>(this.plantURL+'/viewByName/'+name);
  }

  viewByType(name:string):Observable<any[]>{
    return this.h.get<any[]>(this.plantURL+'/viewAll/'+name);
  }
}
