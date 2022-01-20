import { Component, OnInit } from '@angular/core';
import { BmsService } from '../bms.service';
import { Bms } from '../model/Bms';

@Component({
  selector: 'app-bms',
  templateUrl: './bms.component.html',
  styleUrls: ['./bms.component.css']
})
export class BmsComponent implements OnInit {

  bms:Bms=new Bms();
  bmsList:Bms[]=[this.bms];
  customers:any=[];
  products:any=[];



  constructor(private bmsService:BmsService) { }

  ngOnInit(): void {
    console.log(this.bmsList)
    this.bmsService.getBmsList().subscribe((data:any)=>{
      console.log(data);
      if(data['length']>0){
        this.bmsList=data;
        this.bmsList[0]['dateCreated']=new Date();
       this.customers=data[0]['customers'];
       this.products=data[0]['products'];

      }
    
       
    },err=>{})
  }
  save(){
    this.bmsService.saveBmsList(this.bmsList).subscribe(data=>{
      console.log(data);
    },error=>{})
  }
  addBms(){
    this.bmsList.push(new Bms());
  }
  deleteBms(index:number){
    if(this.bmsList.length!=1)
      this.bmsList.splice(index,1);
    else 
     alert('Cannot delete')  
  }

  cal(bms:any){
    bms.totalAmt = bms.quantity * bms.unitPrice;
  }
  calBal(bms:any){
    bms.balanceAmt = bms.totalAmt - bms.customerAmt;

  }


}
