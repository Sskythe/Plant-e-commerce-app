
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminMainComponent } from './admin-main/admin-main.component';
import { CreateNewUserComponent } from './create-new-user/create-new-user.component';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { HomeComponent } from './home/home.component';
import { ManageCustomersComponent } from './manage-customers/manage-customers.component';
import { ModifyuserComponent } from './modifyuser/modifyuser.component';
import { OrderCustomerComponent } from './order-customer/order-customer.component';
import { OrderMainComponent } from './order-main/order-main.component';



import { PlantMainComponent } from './plant-main/plant-main.component';
import { PlanterMainComponent } from './planter-main/planter-main.component';



import { SeedMainComponent } from './seed-main/seed-main.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'modifyuser',
    component:ModifyuserComponent
  },
  
  {
    path:'adminhome',
    component:AdminMainComponent 
  },
  {
    path:'plantmain',
    component:PlantMainComponent
  },{
    path:'plantermain',
    component:PlanterMainComponent
  },
  {
    path:'customermain',
    component:ManageCustomersComponent
  },
  {
    path:'seedMain',
    component:SeedMainComponent
  },{
    path:'newUser',
    component:CreateNewUserComponent
  },{
    path:'customerhome',
    component:CustomerMainComponent
  },{
    path:'ordermain',
    component:OrderMainComponent
  },{
    path:'orderCustomer',
    component:OrderCustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
