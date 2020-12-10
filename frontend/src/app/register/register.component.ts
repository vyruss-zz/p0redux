import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../models/Customer';
import { User } from '../models/User';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private user: User;
  private customer: Customer;

  usernameError: String;
  passwordError: String;
  firstNameError: String;
  lastNameError: String;

  regForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    firstName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]*')]),
    lastName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]*')])
  })

  attemptRegistration() {
    console.log(this.regForm.controls['username'].value);
    let validSubmission = true;
    if(this.regForm.controls['username'].value=='') {
      validSubmission=false;
      this.usernameError='Please enter a username.';
    } else {
      this.usernameError='';
    }
    if(this.regForm.controls['password'].value=='') {
      this.passwordError='Please enter a password.'
    } else {
      this.passwordError='';
    }
    if(this.regForm.controls['firstName'].value=='') {
      validSubmission=false;
      this.usernameError='Please enter First Name.';
    } else {
      this.usernameError='';
    }
    if(this.regForm.controls['lastName'].value=='') {
      this.passwordError='Please enter Last Name.'
    } else {
      this.passwordError='';
    }
    if(validSubmission) {
      this.user.username=this.regForm.controls['username'].value;
      this.user.password=this.regForm.controls['password'].value;

      this.customer.firstName=this.regForm.controls['firstName'].value;
      this.customer.lastName=this.regForm.controls['lastName'].value;
      this.regService.sendUserRegistration(this.user).subscribe(
        data => {
          console.log(data);
          this.user=data;
          this.customer.myUser=this.user;
          this.regService.sendCustomerRegistration(this.customer).subscribe(
            custData => {
            console.log(custData);});
            this.router.navigate(['/login'])
          
          
        }, (error) => {
          console.log(error.error.message);
          if(error.error.message.match('username')) this.usernameError='Username is already in use.';

        }
      );
    }
  }

  constructor(private regService: RegisterService, private router: Router) { }

  ngOnInit(): void {
    this.user = {
      userId:0,
      username:'',
      password:''
    }

    this.customer= {
      customerId:0,
      firstName:'',
      lastName:'',
      myUser:null
    }
  }

}
