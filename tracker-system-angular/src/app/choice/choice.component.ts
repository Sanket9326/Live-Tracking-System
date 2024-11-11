import { Component } from '@angular/core';
import {Router} from '@angular/router'

@Component({
  selector: 'app-choice',
  standalone: true,
  imports: [],
  templateUrl: './choice.component.html',
  styleUrl: './choice.component.css'
})
export class ChoiceComponent {

      public constructor(private route : Router){}

      choiceIsLiveTracking(){
          this.route.navigate(['/live']);
      }
      choiceIsPastTracking(){
          this.route.navigate(['/home']);
      }
}
