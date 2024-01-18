import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plant } from '../Plant';
import { PlantServiceService } from '../plant-service.service';

@Component({
  selector: 'app-plant-main',
  templateUrl: './plant-main.component.html',
  styleUrls: ['./plant-main.component.css']
})
export class PlantMainComponent implements OnInit {

  tableshow:boolean=false;
  check:boolean=true;
  id:number;
  commonName:string;
  type:string;
 
  plants:Plant[]=[];
  plant:Plant=new Plant();
  planttt:Plant=new Plant();

  constructor(private p:PlantServiceService,private r:Router) { 
    
  }

  ngOnInit(): void {
  }


  deletePlant(id:number):void{
    this.p.deletePlant(id).subscribe((pl)=>{
      this.plant=pl;
      this.viewall();
      alert('Plant deleted successfully');
    });
  }

  modify(p:Plant):void{
    this.check=false;
    this.plant=p;
  }

  viewPlantById():void{
    this.plants=[];
    this.p.viewPlantById(this.id).subscribe((p1)=>this.plants.push(p1)
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  viewPlantByCommonName():void{
    this.plants=[];
      this.p.viewBycommonName(this.commonName).subscribe((p1)=>this.plants.push(p1)
      ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  
  }

  viewPlantBytype():void{
    this.p.viewByType(this.type).subscribe((p1)=>this.plants=p1
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });
    
  }

  viewall():void{
      
    
    this.p.getAllPlants().subscribe((pl)=>{this.plants=[];
      this.plants=pl;
      this.tableshow=true;
    }
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  addPlant():void{
    this.p.addPlant(this.plant).subscribe(
      (p1)=>{this.planttt=p1,
        alert('Plant added successfully!!!!')
      },
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  }
    );

  

    

    this.plant=new Plant();

    


}

modPlant():void{
  this.p.modifyPlant(this.plant).subscribe(
    (p1)=>this.planttt=p1,
  (err:any) => {
        
    if (err['error'].msg != 'undefined') {
      
      alert(err['error'].msg);
      
    }
    

}
  );



  

  this.plant=new Plant();

}

add():void
{
  this.check=true;
}

back():void{
  
  this.r.navigate(['/adminhome']);
}
}
