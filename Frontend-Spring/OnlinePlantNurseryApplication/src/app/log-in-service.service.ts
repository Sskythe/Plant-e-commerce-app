import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LogInServiceService {

  LoginURL:string="http://localhost:9091/login";

  constructor(private h:HttpClient) {

   }

   loginAdmin(username:string,password:string):Observable<any>{

     return this.h.get<any>(this.LoginURL+"/signinAdmin/"+username+"/"+password);

   }

   loginUser(username:string,password:string):Observable<any>{

    return this.h.get<any>(this.LoginURL+"/signinCustomer/"+username+"/"+password);

  }
}
