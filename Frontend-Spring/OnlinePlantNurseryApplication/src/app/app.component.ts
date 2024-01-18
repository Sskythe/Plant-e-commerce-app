import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Plant } from './Plant';
import { PlantServiceService } from './plant-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  plants:Plant[]=[];
  
  constructor(private m:PlantServiceService){

    this.m.getAllPlants().subscribe((p)=>this.plants=p);

  }

  



 
}
