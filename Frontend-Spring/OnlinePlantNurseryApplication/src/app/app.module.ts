import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import{HttpClientModule} from'@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { HomeComponent } from './home/home.component';
import { AdminMainComponent } from './admin-main/admin-main.component';
import { CreateNewUserComponent } from './create-new-user/create-new-user.component';

import { FormsModule } from '@angular/forms';
import { PlantMainComponent } from './plant-main/plant-main.component';

import { SeedMainComponent } from './seed-main/seed-main.component';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { PlanterMainComponent } from './planter-main/planter-main.component';
import { OrderMainComponent } from './order-main/order-main.component';
import { ManageCustomersComponent } from './manage-customers/manage-customers.component';
import { OrderCustomerComponent } from './order-customer/order-customer.component';
import { ModifyuserComponent } from './modifyuser/modifyuser.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminMainComponent,
    CreateNewUserComponent,
    PlantMainComponent,
    SeedMainComponent,
    CustomerMainComponent,
    PlanterMainComponent,
    OrderMainComponent,
    ManageCustomersComponent,
    OrderCustomerComponent,
    ModifyuserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
