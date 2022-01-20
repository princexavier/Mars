import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './model/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  apiUrl:string="http://localhost:8084";
  constructor(private http : HttpClient) { }

  getAllCustomers(){
    return this.http.get(this.apiUrl+"/getAllCustomers")
  }
  saveCustomer(requstData:Customer){
    return this.http.post(this.apiUrl+"/addCustomer",requstData)
  }
}
