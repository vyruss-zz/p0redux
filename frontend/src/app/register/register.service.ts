import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../models/Customer';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  sendUserRegistration(user: User): Observable<User> {
    return this.http.post<User>("http://localhost:8080/api/registerUser", user);
  }
  sendCustomerRegistration(customer: Customer): Observable<any> {
    return this.http.post<Customer>("http://localhost:8080/api/registerCustomer",  customer);
  }
}
