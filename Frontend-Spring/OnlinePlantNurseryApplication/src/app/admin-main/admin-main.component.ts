import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-main',
  templateUrl: './admin-main.component.html',
  styleUrls: ['./admin-main.component.css']
})
export class AdminMainComponent implements OnInit {

  constructor(private r:Router) { }

  ngOnInit(): void {
  }

  logout():void{
    alert('Admin you are logging out...Thank You!!!');
    this.r.navigate(['/']);
  }

}
