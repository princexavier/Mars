import { ReportsService } from './../reports.service';
import { Component, OnInit } from '@angular/core';
import { Bms } from '../model/Bms';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

  constructor(private reportService: ReportsService) { }
  filterObject:any={};
  bmsList:Bms[]=[];

  ngOnInit(): void {
  }
  export(type:string){
    if(type=='pdf'){

    }
    else if(type=='excel'){
      
    }
  }
  filter(){
    if(this.filterObject.date)
      {
        this.reportService.filters(this.filterObject).subscribe((data:any)=>{
          this.bmsList=data['data'];
        });
      }
  }
}
