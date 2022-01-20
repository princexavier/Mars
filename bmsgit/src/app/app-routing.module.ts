import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BmsComponent } from './bms/bms.component';
import { CustomerComponent } from './customer/customer.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  {
    path:'customer',
    component:CustomerComponent
  },
  {
    "path":'product',
    component:ProductComponent
  },
  {
    "path":'home',
    component:HomeComponent
  },
  {
    path:'bms',
    component:BmsComponent
  },
  {
    path:'**',
    redirectTo:'home'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
