import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, interval, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrackingService {

  private poolingInterval = 2000;

  constructor(public http: HttpClient) { }

  getTrackingData(id: String, time: String): Observable<any> {
    return interval(this.poolingInterval).pipe(
      switchMap(() => {
        return this.http.get(`http://localhost:8080/live/track?device=${id}&timestamp=${time}`);
      })
    );
  }

}
