import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../Order';
import { OrderServiceService } from '../order-service.service';
import { Planter } from '../Planter';

@Component({
  selector: 'app-order-main',
  templateUrl: './order-main.component.html',
  styleUrls: ['./order-main.component.css']
})
export class OrderMainComponent implements OnInit {
  showdata:boolean=false;
  id:number;
  
 
  orders:Order[]=[];
  order:Order=new Order();
  detail:Planter[]=[];

  constructor(private p:OrderServiceService,private r:Router) { 
    this.p.getAllOrders().subscribe((pl)=>this.orders=pl);
  }

  ngOnInit(): void {
  }


  deleteOrder(id:number):void{
    this.p.deleteOrder(id).subscribe((p1)=>{
      alert("deleted successfully");

    });
  }


  viewOrderById():void{
    this.orders=[];
    this.p.viewOrderById(this.id).subscribe((p1)=>this.orders.push(p1)
    ,

    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  viewall():void{
    this.p.getAllOrders().subscribe((pl)=>this.orders=pl
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  details(p:Order):void{
    this.showdata=true;
    this.detail=p.planters;



  }

  back():void{
  
    this.r.navigate(['/adminhome']);
  }

  
  

    

  

}
