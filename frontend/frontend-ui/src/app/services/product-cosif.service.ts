import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { TargetPaths } from './paths';

@Injectable({
  providedIn: 'root'
})
export class ProductCosifService {

  url = new TargetPaths().backendUrl;

  constructor(private http: HttpClient) { }

  findAll(): Promise<any> {
    return firstValueFrom(
      this.http.get(`${this.url}/productcosif`)
    );
  }
}
