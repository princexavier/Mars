import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../model/Customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private cutomerService:CustomerService) { }
  customer: Customer = new Customer();
  customers:any=[this.customer];
  ngOnInit(): void {
    this.cutomerService.getAllCustomers().subscribe(data=>{
     this.customers=data;
    },error=>{

    });
  }
  save(){
    this.cutomerService.saveCustomer(this.customer).subscribe(data=>{
      console.log(data)
    },error=>{

    });
  }
  addCustomer(){
    this.customers.push(new Customer());

  }
  deleteCustomer(index:number){
    if(this.customers.length!=1)
      this.customers.splice(index,1);
    else 
    alert('Cant delete')
  }

}
