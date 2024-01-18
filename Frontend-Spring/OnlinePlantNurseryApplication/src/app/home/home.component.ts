import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../Admin';
import { Customer } from '../Customer';
import { LogInServiceService } from '../log-in-service.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  checkadmin:boolean=false;
  UserName:string;
  Password:string;
  admin:Admin;
  customer:Customer;


  constructor(private r:Router,private m:LogInServiceService,private s:SharedService) { }

  ngOnInit(): void {
  }

  loginadmin():void{
    this.m.loginAdmin(this.UserName,this.Password).subscribe( (a)=>this.admin=a ,
        (err:any) => {
          
          if (err['error'].msg != 'undefined') {
            
            alert(err['error'].msg);
            this.UserName='';
            this.Password='';
          }

          
        }
        );

        if(this.admin!=null){
          alert("welcome"+" "+this.admin.adminUserName);
          this.r.navigate(['/adminhome']);
        }
        
       
  }

  loginCustomer():void{
    
    this.m.loginUser(this.UserName,this.Password).subscribe( (a)=>this.customer=a ,
        (err:any) => {
          
          if (err['error'].msg != 'undefined') {
            
            alert(err['error'].msg);
            this.UserName='';
            this.Password='';
          }

          
        }
        );

        if(this.customer!=null){
          alert("welcome"+" "+this.customer.username);
          this.s.setCustomer(this.customer);
          //important for data sharing
 this.r.navigate(['/customerhome']);
        }
        
       
  

}

  myfun():void{
    if(this.checkadmin==true)
        this.checkadmin=false;
        else
        this.checkadmin=true;

  }
}
