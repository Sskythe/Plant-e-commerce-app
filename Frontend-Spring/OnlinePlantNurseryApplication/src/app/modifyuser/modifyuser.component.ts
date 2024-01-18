import { Component, OnInit } from '@angular/core';
import { Customer } from '../Customer';
import { CustomerService } from '../customer.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-modifyuser',
  templateUrl: './modifyuser.component.html',
  styleUrls: ['./modifyuser.component.css']
})
export class ModifyuserComponent implements OnInit {
  customer:Customer=new Customer();
  constructor(private p:CustomerService,private s:SharedService) {
    this.customer= this.s.getCustomer();
   }

  ngOnInit(): void {
  }

  modcustomer():void{

    this.p.modifyCustomer(this.customer).subscribe(
      (p1)=>{this.customer=p1;
        alert("customer modify succesfully")},
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  }
    );

  this.customer=new Customer();
  }

}
