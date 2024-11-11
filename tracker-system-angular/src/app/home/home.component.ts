import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  baseurl: string = "http://localhost:8080/data";
  flag: boolean = true;
  private map: any; 

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    import('leaflet').then(L => {
      this.initMap(L); 
    });
  }

  private initMap(L: any): void {
    this.map = L.map('map').setView([20.5937, 78.9629], 5); 

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      attribution: '© OpenStreetMap contributors'
    }).addTo(this.map);
    L.Icon.Default.imagePath = 'assets/leaflet/';
  }

  getData(id: string, stime: string, etime: string) {
    const params = new HttpParams()
      .set('deviceId', id)
      .set('startTime', stime)
      .set('endTime', etime);

    this.http.get<string[][]>(`${this.baseurl}/get`,{params}).subscribe({
      next : (data) =>{
        console.log(data);
        this.addMarkers(data);
      },
      error: (error) => {
        console.error('Error:', error);
      }
    });

  }
  private addMarkers(coordinates: string[][]): void {
    coordinates.forEach(coord => {
      const latitude = parseFloat(coord[0]); 
      const longitude = parseFloat(coord[1]); 
      this.addMarker(latitude, longitude);
    });
  }
  private addMarker(latitude: number, longitude: number): void {
    const L = (window as any).L; 
    L.marker([latitude, longitude]).addTo(this.map)
      .bindPopup(`Latitude: ${latitude}, Longitude: ${longitude}`)
      .openPopup();
  }
}
