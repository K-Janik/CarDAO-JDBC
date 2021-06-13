import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {RootObject} from '../cardao/car';

@Injectable({
  providedIn: 'root'
})
export class CardaoService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private httpClient: HttpClient ) { }

  public getCar(): Observable<RootObject[]> {
    return this.httpClient.get<RootObject[]>(`${this.apiServerUrl}/cars`);
  }
  public insertCar(rootObject: RootObject): Observable<RootObject> {
    return this.httpClient.post<RootObject>(`${this.apiServerUrl}/cars`, rootObject);
  }
  public searchCarsByYear(fromYear: number, untilYear: number): Observable<RootObject[]> {
    return this.httpClient.get<RootObject[]>(`${this.apiServerUrl}/cars/since/${fromYear}/to/${untilYear}`);
  }
  public deleteCarById(carId: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.apiServerUrl}/cars/${carId}`);
  }
}

