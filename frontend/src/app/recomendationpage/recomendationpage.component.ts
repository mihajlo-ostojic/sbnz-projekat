import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,HttpParamsOptions } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recomendationpage',
  templateUrl: './recomendationpage.component.html',
  styleUrls: ['./recomendationpage.component.css']
})
export class RecomendationpageComponent implements OnInit {

  dto: any;
  constructor(private http: HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.getRecomendations();
  }

  getRecomendations() : void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { username: localStorage.getItem("username")};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/recomendations', options)
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
          this.dto = data.books;
        }
        else {
          alert("Can't load book data");
        }
    });
  }

  details(id: any):void {
    localStorage.setItem("bookId", id);
    this.router.navigate(['bookData']);

  }

}
