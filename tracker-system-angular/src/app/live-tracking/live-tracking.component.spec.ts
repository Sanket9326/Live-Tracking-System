import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LiveTrackingComponent } from './live-tracking.component';

describe('LiveTrackingComponent', () => {
  let component: LiveTrackingComponent;
  let fixture: ComponentFixture<LiveTrackingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LiveTrackingComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LiveTrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
