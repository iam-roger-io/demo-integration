import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { ConfigurationsService } from './configurations.service';
import { Person } from '../_models/person';

@Injectable({
  providedIn: 'root'
})
export class BffService {

  configurations:any;

  constructor(private http: HttpClient, private configurationsService:ConfigurationsService) {
    this.configurations = this.configurationsService.settings;
  }

  getAllPerfil(token:any) {

    //token = "TESTE_TOKEN"

    //console.log("########  token " + token);
    const httpOptions = {
      headers: new HttpHeaders({

        'Content-Type':  'application/json',
        'Authorization': 'Bearer '+token,
        'Accept':'application/json'
      })
    };

    const apiBff = this.configurations.apiBff;
    return this.http.get<Person[]>(`${apiBff}`, httpOptions);
  }

}
