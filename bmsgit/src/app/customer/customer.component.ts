import { PlacesService } from './../places.service';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../model/Customer';
import { Place } from '../model/Place';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private cutomerService:CustomerService,private placesService : PlacesService) { }
  customer: Customer = new Customer();
  customers:any=[this.customer];
  places:Place[]=[];
  ngOnInit(): void {

    this.placesService.getAllPlaces().subscribe((data:any)=>{
      if(data)
       {
        console.log(data.places)
        this.places=data.places;
       }
    })
    this.cutomerService.getAllCustomers().subscribe(data=>{
     this.customers=data;
    },error=>{

    });
  }
  save(form:any){
    console.log(form.valid)
   if(form.valid){
    this.cutomerService.saveCustomer(this.customer).subscribe(data=>{
      console.log(data)
      if(data)
       this.ngOnInit()
    },error=>{

    });
    this.customer=new Customer()
   }
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

  validate(type:any){
    console.log(type)
  }

  editCustomer(customer:any){
    this.customer.fname = customer.fname;
    this.customer.lname = customer.lname;
    this.customer.phoneNumber = customer.phoneNumber;
    this.customer.email = customer.email;
    this.customer.id = customer.id;

  }

  deleteCustomerD(customerId:any){
    this.cutomerService.deleteCustomer(customerId).subscribe((data:any)=>{
      if(data)
       this.ngOnInit()
    });
  }

}
