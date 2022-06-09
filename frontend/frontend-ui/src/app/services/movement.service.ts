import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { TargetPaths } from './paths';
import { Movement } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MovementService {

  url = new TargetPaths().backendUrl;

  constructor(private http: HttpClient) { }

  findAll(): Promise<any> {
    return firstValueFrom(
      this.http.get(`${this.url}/movements`)
    );
  }

  save(movement: Movement): Promise<any> {
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/json');

    return firstValueFrom(
      this.http.post(`${this.url}/movements`, movement, { headers })
    );
  }
}
