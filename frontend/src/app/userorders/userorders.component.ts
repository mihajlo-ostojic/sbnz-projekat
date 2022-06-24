import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,HttpParamsOptions } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userorders',
  templateUrl: './userorders.component.html',
  styleUrls: ['./userorders.component.css']
})
export class UserordersComponent implements OnInit {

  orders: any;
  constructor(private http: HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders() : void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { userId: localStorage.getItem("userId")};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/userorders', options)
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
          this.orders = data;
        }
        else {
          alert("Can't load book data");
        }
    });
  }

  cancel(id: any):void {

    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    const myObject: any = { userId: localStorage.getItem("userId"), orderId: id};
    const httpParams: HttpParamsOptions = { fromObject: myObject } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams), headers: headers };

    this.http.get<any>('http://localhost:8080/cancelorder', options)
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
          alert("order canceled");
        }
        else {
          alert("Can't load book data");
        }
    });

  }

}
