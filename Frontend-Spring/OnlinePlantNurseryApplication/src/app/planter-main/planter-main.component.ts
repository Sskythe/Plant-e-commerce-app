import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plant } from '../Plant';
import { PlantServiceService } from '../plant-service.service';
import { Planter } from '../Planter';
import { PlanterServiceService } from '../planter-service.service';
import { Seed } from '../Seed';
import { SeedServiceService } from '../seed-service.service';

@Component({
  selector: 'app-planter-main',
  templateUrl: './planter-main.component.html',
  styleUrls: ['./planter-main.component.css']
})
export class PlanterMainComponent implements OnInit {
  showtable:boolean=false;

  check1:boolean=true;
  check2:boolean=false;
  check3:boolean=false;
  id:number;
  planterShape:string;
  minCost:number;
  maxCost:number;
 
  planters:Planter[]=[];
  planter:Planter=new Planter();

  plants:Plant[]=[];
  plantschoosen:Plant[]=[];

  seeds:Seed[]=[];
  seedschoosen:Seed[]=[];

  plantermain:Planter=new Planter();
 

  constructor(private p:PlanterServiceService,private ps:PlantServiceService,private s:SeedServiceService,private r:Router) { 
    this.p.getAllPlanters().subscribe((pl)=>this.planters=pl);
    this.ps.getAllPlants().subscribe((pl)=>this.plants=pl);
    this.s.getAllSeeds().subscribe((pl)=>this.seeds=pl);
  }

  ngOnInit(): void {
  }

  addtoplantlist(p:Plant):void{
    this.plantschoosen.push(p);
  }

  addtoseedlist(p:Seed):void{
    this.seedschoosen.push(p);
  }

  addPlanter():void{
    this.p.addPlanter(this.planter).subscribe(
      (p1)=>{this.planter=p1;
      alert('Planter Added successfully')},
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  }
    );


  }

  viewall():void{


    this.p.getAllPlanters().subscribe((pl)=>{this.planters=[];
      this.planters=pl;
      this.showtable=true;}
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });
  }

  modPlanter():void{

    this.planter.plants=this.plantschoosen;
    this.planter.seeds=this.seedschoosen;

    this.p.modifyPlanter(this.planter).subscribe(
          (p1)=>{this.planter=p1,
            alert('modify successfully');
          },
        (err:any) => {
              
          if (err['error'].msg != 'undefined') {
            
            alert(err['error'].msg);
            
          }
          
      
      }
        );

    this.check1=true;
    this.check2=false;
    this.check3=false;

  }


  deletePlanter(id:number):void{
    this.p.deletePlanter(id).subscribe((pl)=>this.planter=pl);
  }

  modify(p:Planter):void{
    this.check1=false;
    this.check2=true;
    this.check3=false;
    this.planter=p;
  }

  viewPlanterById():void{
    this.planters=[];
    this.p.viewPlanterById(this.id).subscribe((p1)=>this.planters.push(p1)
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  viewPlanterByShape():void{
    this.planters=[];
      this.p.viewByPlanterShape(this.planterShape).subscribe((p1)=>this.planters.push(p1)
      ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });
  }

  viewPlanterByRange():void{
    this.planters=[];
    this.p.viewPlanterInRange(this.minCost,this.maxCost).subscribe((p1)=>this.planters=p1
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });
    
  }

  showdetails(p:Planter):void{
    this.check1=false;
    this.check2=false;
    this.check3=true;
    this.planter=p;
    this.plants=p.plants;
    this.seeds=p.seeds;
  }

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

add():void
{
  this.check1=true;
  this.check2=false;
  this.check3=false;
}

back():void{
  
  this.r.navigate(['/adminhome']);
}

}
