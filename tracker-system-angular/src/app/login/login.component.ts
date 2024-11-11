import { Component, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { EventEmitter } from '@angular/core';
import { Route, RouterModule, Router } from '@angular/router';
import { response } from 'express';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  Email: string = '';
  Password: string = '';

  constructor(private http: HttpClient, private route: Router) { }

  getData(formValue: any) {
    const loginData = { username: formValue.username, password: formValue.password };

    this.http.post('http://localhost:8080/user/login', loginData, { responseType: 'json' })
      .subscribe(
        (response: any) => {
          console.log("Success");
          this.route.navigate(['/choice']);
        },
        (error: any) => {
          alert("Invalid Credentials");
          console.error('Login failed:', error);
        }
      );
  }

  signUp(data: any) {
    const userData = { email: data.username, password: data.password };
    this.http.put('http://localhost:8080/user/new', userData).subscribe(
      (response: any) => {
        console.log("Success");
      },
      (error: any) => {
        // console.error('Error:', error);
      }
    );
  }
}
