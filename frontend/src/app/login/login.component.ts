import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,HttpParamsOptions } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username : string;
  public password : string;
  constructor(private http: HttpClient, private router : Router) { 

    this.username = "";
    this.password = "";
  }

  ngOnInit(): void {
  }

  login() {

    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { username: this.username, password: this.password};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/login', options)
      .subscribe((data: any) => {
        console.log(JSON.stringify(data));
        if(data!=null)
        {
          localStorage.setItem("username", data.username);
          localStorage.setItem("password", data.password);
          localStorage.setItem("userId", data.userId);
          console.log(localStorage.getItem("username"));
          console.log(localStorage.getItem("password"));
          console.log(localStorage.getItem("userId"));
          alert("Logged in");
          this.router.navigate(['home']);
        }
        else {
          alert("Wrong username or password");
        }
    });
  }

  signup() {
    // this.userService.signup(this.username, this.password);
  }

}
