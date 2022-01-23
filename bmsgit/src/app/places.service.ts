import { BackEndDetail } from './model/BackEndDetail';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Place } from './model/Place';

@Injectable({
  providedIn: 'root'
})
export class PlacesService {
  getAllPlaces() {
    return this.http.get(this.backendProps.apiUrl+"/getAllPlaces");
    
  }

  constructor(private http : HttpClient,private backendProps: BackEndDetail) { }

  save(place:Place){
    return this.http.post(this.backendProps.apiUrl+"/savePlace",place);
  }
}
