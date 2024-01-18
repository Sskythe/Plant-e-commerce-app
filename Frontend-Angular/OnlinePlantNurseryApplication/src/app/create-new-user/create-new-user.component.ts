import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-create-new-user',
  templateUrl: './create-new-user.component.html',
  styleUrls: ['./create-new-user.component.css']
})
export class CreateNewUserComponent implements OnInit {

  customer:Customer=new Customer();
  constructor(private p:CustomerService,private r:Router) { }

  ngOnInit(): void {
  }

  addcustomer():void{

    this.p.addCustomer(this.customer).subscribe(
      (p1)=>{this.customer=p1;
        alert("customer added succesfully");
        this.r.navigate(['/']);
        
      },
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  }
    );

    

  this.customer=new Customer();
  }

}
