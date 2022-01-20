import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/Customer';
import { Product } from '../model/Product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private productService:ProductService) { }


  product: Product = new Product();
  products:any=[this.product];
  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(data=>{
     this.products=data;
    },error=>{

    });
  }
  save(){
    this.productService.saveProduct(this.product).subscribe(data=>{
      console.log(data)
    },error=>{

    });
  }
  addCustomer(){
    this.products.push(new Customer());

  }
  deleteCustomer(index:number){
    if(this.products.length!=1)
      this.products.splice(index,1);
    else 
    alert('Cant delete')
  }

}
