import { Component, OnInit } from '@angular/core';
import { Customer } from '../Customer';

import { Order } from '../Order';
import { Planter } from '../Planter';
import { PlanterServiceService } from '../planter-service.service';
import { SharedService } from '../shared.service';
import { DatePipe } from '@angular/common';
import { OrderServiceService } from '../order-service.service';


@Component({
  selector: 'app-order-customer',
  templateUrl: './order-customer.component.html',
  styleUrls: ['./order-customer.component.css']
})
export class OrderCustomerComponent implements OnInit {

  show1:boolean=false;
  show1_orders:Order[]=[];
  show2:boolean=true;

  customer:Customer=new Customer();
  tableshow:boolean=false;
  order:Order=new Order();
  orders:Order[]=[];
  planters:Planter[]=[];

  constructor(private p:OrderServiceService,private s:SharedService,private pl:PlanterServiceService) { 
    this.customer=s.getCustomer();
    // this.pl.getAllPlanters().subscribe((p1)=>this.planters=p1);
   
  }

  ngOnInit(): void {
  }

  newOrder():void{
    this.tableshow=true;
    this.show1=false;
    this.pl.getAllPlanters().subscribe((p1)=>this.planters=p1);
  }

  yourOrder():void{
    this.show1=true;
    this.tableshow=false;
    this.show1_orders=this.customer.orders;
    if(this.show1_orders.length<=0){
      alert('no orders for this costumer');
    }else{
      this.orders=this.show1_orders;
    }
    
  }

  
  
  addOrder():void{
    // let date:string=this.datePipe.transform(Date.now(),'yyyy-MM-dd');
    // this.order.OrderDate=new Date(date);
    // this.order.OrderDate=new Date(Date.now());
    // alert(this.order.OrderDate);
    // this.order.quantity=0;
    // this.order.totalCost=0;

    let o:Order=new Order();
    o.quantity=0;
    o.totalCost=0;
    o.transactionMode='online';
    o.OrderDate=new Date();
    o.planters=[];
    

    this.p.addOrder(o).subscribe(
            (p1)=>{
              alert('order placed');},
          (err:any) => {
                
            if (err['error'].msg != 'undefined') {
              
              alert(err['error'].msg);
              
            }
            
      
        }
          );
      
      
          
      



  }

  deleteorder(p:number):void{
    this.p.deleteOrder(p).subscribe((pl)=>{
      
      
      alert('Order deleted successfully');
    });

  }

  // addOrdersscreen():void{
  //   this.orders=this.customer.orders; 

  // }


//   deletePlant(id:number):void{
//     this.p.deletePlant(id).subscribe((pl)=>this.plant=pl);
//   }

//   modify(p:Plant):void{
//     this.check=false;
//     this.plant=p;
//   }

//   viewPlantById():void{
//     this.plants=[];
//     this.p.viewPlantById(this.id).subscribe((p1)=>this.plants.push(p1)
//     ,
//     (err:any) => {
          
//       if (err['error'].msg != 'undefined') {
        
//         alert(err['error'].msg);
        
//       }
      

//   });

//   }

//   viewPlantByCommonName():void{
//     this.plants=[];
//       this.p.viewBycommonName(this.commonName).subscribe((p1)=>this.plants.push(p1)
//       ,
//     (err:any) => {
          
//       if (err['error'].msg != 'undefined') {
        
//         alert(err['error'].msg);
        
//       }
      

//   });
//   }

//   viewPlantBytype():void{
//     this.p.viewByType(this.type).subscribe((p1)=>this.plants=p1
//     ,
//     (err:any) => {
          
//       if (err['error'].msg != 'undefined') {
        
//         alert(err['error'].msg);
        
//       }
      

//   });
    
//   }

//   viewall():void{
//     this.p.getAllPlants().subscribe((pl)=>this.plants=pl
//     ,
//     (err:any) => {
          
//       if (err['error'].msg != 'undefined') {
        
//         alert(err['error'].msg);
        
//       }
      

//   });

//   }

//   addPlant():void{
//     this.p.addPlant(this.plant).subscribe(
//       (p1)=>this.planttt=p1,
//     (err:any) => {
          
//       if (err['error'].msg != 'undefined') {
        
//         alert(err['error'].msg);
        
//       }
      

//   }
//     );

  

    

//     this.plant=new Plant();

    


// }

// modPlant():void{
//   this.p.modifyPlant(this.plant).subscribe(
//     (p1)=>this.planttt=p1,
//   (err:any) => {
        
//     if (err['error'].msg != 'undefined') {
      
//       alert(err['error'].msg);
      
//     }
    

// }
//   );



  

//   this.plant=new Plant();

// }

// add():void
// {
//   this.check=true;
// }

}
