import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-manage-customers',
  templateUrl: './manage-customers.component.html',
  styleUrls: ['./manage-customers.component.css']
})
export class ManageCustomersComponent implements OnInit {

 
  id:number;
  
 
  customers:Customer[]=[];
  customer:Customer=new Customer();
 

  constructor(private p:CustomerService,private r:Router) { 
    this.p.getAllCustomers().subscribe((pl)=>this.customers=pl);
  }

  ngOnInit(): void {
  }


  deleteCustomer(id:number):void{
    this.p.deleteCustomer(id).subscribe((p1)=>{
      alert("deleted successfully");

    });
  }


  viewCustomerById():void{
    this.customers=[];
    this.p.viewCustomerById(this.id).subscribe((p1)=>this.customers.push(p1)
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  viewall():void{
    this.p.getAllCustomers().subscribe((pl)=>this.customers=pl
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  back():void{
  
    this.r.navigate(['/adminhome']);
  }

  
  

    

    
}
