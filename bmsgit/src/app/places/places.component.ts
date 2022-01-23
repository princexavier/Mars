import { PlacesService } from './../places.service';
import { Component, OnInit } from '@angular/core';
import { Place } from '../model/Place';

@Component({
  selector: 'app-places',
  templateUrl: './places.component.html',
  styleUrls: ['./places.component.css']
})
export class PlacesComponent implements OnInit {
place:Place=new Place();
errorMessage:string="";
  constructor(private placesService: PlacesService) { }

  ngOnInit(): void {
  }

  save(){
    this.placesService.save(this.place).subscribe((data:any)=>{
      console.log(data)
    },
    err=>{
      this.errorMessage=err;
    })

  }

}
