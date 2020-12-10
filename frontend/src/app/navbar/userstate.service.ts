import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserstateService {

  userState: boolean = false;
  firstName: String;
  lastName: String;
  constructor() { }
}
