import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seed } from './Seed';

@Injectable({
  providedIn: 'root'
})
export class SeedServiceService {

  seedURL:string="http://localhost:9091/seed";

  constructor(private h:HttpClient) { }

  getAllSeeds():Observable<any[]>{
    return this.h.get<any[]>(this.seedURL + '/viewAllSeed');
  }
  
  addSeed(p:Seed):Observable<any>{
    return this.h.post(this.seedURL + '/addseed',p,{responseType:"text"});
  }

  modifySeed(p:Seed):Observable<any>{
    return this.h.put(this.seedURL + '/updateSeed',p,{responseType:"text"});
  }

  deleteSeed(id:number):Observable<any>{
    return this.h.delete(this.seedURL +'/deleteSeed/'+id);
  }

  viewSeedById(id:number):Observable<any>{
    return this.h.get<any>(this.seedURL+'/viewSeedById/'+id);
  }

  viewBycommonName(name:string):Observable<any>{
    return this.h.get<any>(this.seedURL+'/viewSeedByCommonName/'+name);
  }

  viewByType(name:string):Observable<any[]>{
    return this.h.get<any[]>(this.seedURL+'/viewSeedsByType/'+name);
  }
}
