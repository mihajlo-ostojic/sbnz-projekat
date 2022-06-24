import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,HttpParamsOptions } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bookinfo',
  templateUrl: './bookinfo.component.html',
  styleUrls: ['./bookinfo.component.css']
})
export class BookinfoComponent implements OnInit {

  book: any;
  amount: any;
  comment: any;
  status1: boolean;
  status2: boolean;
  mark : any;
  constructor(private http: HttpClient, private router : Router) { 
    this.status1 = false;
    this.status2 = false;
  }

  ngOnInit(): void {
    this.getBook();
  }

  getBook() : void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { bookId: localStorage.getItem("bookId")};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/bookData', options)
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
          this.book = data;
        }
        else {
          alert("Can't load book data");
        }
    });
  }

  addComment(): void {

    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { bookId: localStorage.getItem("bookId"),userId: localStorage.getItem("userId"),content: this.comment,statuss: this.status1};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/addComment', options)
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
          alert("Added comment");
        }
        else {
          alert("Can't load comment");
        }
    });

  }

  addMark(): void {

    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { userId: localStorage.getItem("userId"), bookId: localStorage.getItem("bookId"),mark: this.mark};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/markbook', options)
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
          alert("Added mark");
        }
        else {
          alert("Can't load mark");
        }
    });

  }

  shareInfo(): void {

    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { userId: localStorage.getItem("userId"), bookId: localStorage.getItem("bookId")};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/shareinfo', options)
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
          alert("Added mark");
        }
        else {
          alert("Can't load mark");
        }
    });

  }

  buy(): void {

    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { userId: localStorage.getItem("userId"), bookId: localStorage.getItem("bookId"), amount: this.amount};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/addOrder', options)
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
          alert("Added order");
        }
        else {
          alert("Can't load order");
        }
    });

  }

}
