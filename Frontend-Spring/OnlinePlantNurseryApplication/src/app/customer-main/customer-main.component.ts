import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-customer-main',
  templateUrl: './customer-main.component.html',
  styleUrls: ['./customer-main.component.css']
})
export class CustomerMainComponent implements OnInit {
  customermain:Customer;

  constructor(private s:SharedService,private r:Router) { 
   this.customermain= this.s.getCustomer();
  }

  ngOnInit(): void {
  }

  logout():void{
    alert('Logging out...Thank You!!!');
    this.r.navigate(['/']);
  }

}
