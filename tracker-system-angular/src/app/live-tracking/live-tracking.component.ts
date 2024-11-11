import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http'
import { TrackingService } from '../services/tracking.service'

@Component({
  selector: 'app-live-tracking',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './live-tracking.component.html',
  styleUrl: './live-tracking.component.css'
})
export class LiveTrackingComponent {
  private map: any;

  public constructor(public http: HttpClient, private trackingService: TrackingService) {

  }

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

  timestamp: string = new Date().toISOString().split('.')[0];

  getLiveTracking(id: String) {
    this.trackingService.getTrackingData(id, this.timestamp).subscribe(
      (response) => {
        console.log(response);
        this.addMarkers(response);
      },
      (error) => {
        console.error(error);
      }
    );
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
