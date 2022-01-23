import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../app/model/Product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  deleteProductD(productId: any) {
    return this.http.post(this.apiUrl+"/deleteProduct",productId);
  }
  apiUrl:string="http://localhost:8084";
  constructor(private http :HttpClient) { }
  getAllProducts(){
    return this.http.get(this.apiUrl+"/getAllProducts")
  }
  saveProduct(product:Product){
    return this.http.post(this.apiUrl+"/addProduct",product)
  }

}
