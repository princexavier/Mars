import { BackEndDetail } from './model/BackEndDetail';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  constructor(private http :HttpClient,private api : BackEndDetail) { }

  filters(filters:any){
    return this.http.post(this.api.getApiUrl()+"/reports",filters);
  }
}
