import { BackEndDetail } from './model/BackEndDetail';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { ProductComponent } from './product/product.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BmsComponent } from './bms/bms.component';
import { ReportsComponent } from './reports/reports.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    ProductComponent,
    HomeComponent,
    BmsComponent,
    ReportsComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    
    
    
  ],
  providers: [BackEndDetail],
  bootstrap: [AppComponent]
})
export class AppModule { }
