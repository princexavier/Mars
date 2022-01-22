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
  bmsList:Bms[]=[];
  bmsCustomList:Bms[]=[this.bms];
  customers:any=[];
  products:any=[];
  disableFlag:boolean=true;



  constructor(private bmsService:BmsService) { }

  ngOnInit(): void {

    
    this.bmsService.getDropValues().subscribe((data:any)=>{
      if(data){
      this.customers = data['customers'];
      this.products=data['products'];  
      }
    });

    console.log(this.bmsList)
    this.bmsService.getBmsList().subscribe((data:any)=>{
      console.log(data);
      if(data){
        this.bmsList=data['bms'];
        
      }
    
       
    },err=>{})
  }
  save(){
    this.bmsService.saveBmsList(this.bmsCustomList).subscribe(data=>{
      console.log(data);
      if(data)
       this.ngOnInit()
    },error=>{})
  }
  addBms(){
    this.bmsCustomList.push(new Bms());
    this.disableFlag=false;
  }
  deleteBms(index:number){
    if(this.bmsCustomList.length!=1)
      this.bmsCustomList.splice(index,1);

     if(this.bmsCustomList.length==1){
     this.disableFlag=true; 

     }
  }

  cal(bms:any){
    bms.totalAmt = bms.quantity * bms.unitPrice;
  }
  calBal(bms:any){
    bms.balanceAmt = bms.totalAmt - bms.customerAmt;

  }


}
