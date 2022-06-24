import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,HttpParamsOptions } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  allBooks: any;
  constructor(private http: HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks() : void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { };
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/allbooks', options)
      .subscribe((data: any) => {
        console.log(JSON.stringify(data));
        if(data!=null)
        {
          // localStorage.setItem("username", data.username);
          // localStorage.setItem("password", data.password);
          // localStorage.setItem("userId", data.userId);
          // console.log(localStorage.getItem("username"));
          // console.log(localStorage.getItem("password"));
          // console.log(localStorage.getItem("userId"));
          // alert("Logged in");
          // this.router.navigate(['home']);
          this.allBooks = data;
        }
        else {
          alert("Wrong username or password");
        }
    });
  }

  details(id: any):void {
    localStorage.setItem("bookId", id);
    this.router.navigate(['bookData']);

  }

  loadProfile() : void {
    this.router.navigate(['profile']);
  }

  loadOrders() : void {
    this.router.navigate(['orders']);
  }

  recomendations() : void {
    this.router.navigate(['recomendations']);
  }
}
