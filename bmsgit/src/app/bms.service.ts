import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bms } from '../app/model/Bms';


@Injectable({
  providedIn: 'root'
})
export class BmsService {

  private apiUrl: string = "http://localhost:8084";

  constructor(private http: HttpClient) { }

  saveBmsList(bmsList: any) {
    return this.http.post(this.apiUrl + "/saveBmsList", bmsList);
  }
  getBmsList() {
    return this.http.get(this.apiUrl + "/getBmsList");
  }

  getDropValues() {
    return this.http.get(this.apiUrl + "/getDropValues");
  }
  

}
