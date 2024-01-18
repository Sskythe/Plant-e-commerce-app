import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Seed } from '../Seed';
import { SeedServiceService } from '../seed-service.service';

@Component({
  selector: 'app-seed-main',
  templateUrl: './seed-main.component.html',
  styleUrls: ['./seed-main.component.css']
})
export class SeedMainComponent implements OnInit {

  tableshow:boolean=false;
  check:boolean=true;
  id:number;
  commonName:string;
  type:string;

  seeds:Seed[]=[];
  seed:Seed=new Seed();
  seedetc:Seed=new Seed();
 
 

  constructor(private p:SeedServiceService,private r:Router) { 
   
  }


  ngOnInit(): void {
  }


  deleteSeed(id:number):void{
    this.p.deleteSeed(id).subscribe((pl)=>{this.seed=pl;
      this.viewall();
      alert('Seed deleted successfully');
    });
  }

  modify(s:Seed):void{
    this.check=false;
    this.seed=s;
  }

  viewSeedById():void{
    this.seeds=[];
    this.p.viewSeedById(this.id).subscribe((p1)=>this.seeds.push(p1)
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  viewSeedByCommonName():void{
    this.seeds=[];
      this.p.viewBycommonName(this.commonName).subscribe((p1)=>this.seeds.push(p1)
      ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });
  }

  viewSeedBytype():void{
    this.p.viewByType(this.type).subscribe((p1)=>this.seeds=p1
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });
    
  }

  viewall():void{
    this.p.getAllSeeds().subscribe((pl)=>{
      this.seeds=[];
        this.seeds=pl;
        this.tableshow=true;
      
    }
    ,
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  });

  }

  addSeed():void{
    this.p.addSeed(this.seed).subscribe(
      (p1)=>{this.seedetc=p1;
        alert('Plant added successfully!!!!')
      },
    (err:any) => {
          
      if (err['error'].msg != 'undefined') {
        
        alert(err['error'].msg);
        
      }
      

  }
    );

  

    

    this.seed=new Seed();

    


}

modSeed():void{
  this.p.modifySeed(this.seed).subscribe(
    (p1)=>this.seedetc=p1,
  (err:any) => {
        
    if (err['error'].msg != 'undefined') {
      
      alert(err['error'].msg);
      
    }
    

}
  );



  

  this.seed=new Seed();

}

add():void
{
  this.check=true;
}

back():void{
  
  this.r.navigate(['/adminhome']);
}

}
