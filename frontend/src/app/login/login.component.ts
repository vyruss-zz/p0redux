import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/User';
import { UserstateService } from '../navbar/userstate.service';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  private user: User;

  usernameError: String;
  passwordError: String;

  regForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  })

  attemptLogin() {
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
    if(validSubmission) {
      this.user.username=this.regForm.controls['username'].value;
      this.user.password=this.regForm.controls['password'].value;

      this.loginService.sendLogin(this.user).subscribe(
        data => {
          console.log(data);
          if(data.username=='Invalid Username') {
            this.usernameError='Invalid Username';
          } else {
            this.usernameError='';
            if(data.password=='Invalid Password') {
              this.passwordError='Invalid Password';
            } else {
              this.userState.userState=true;
              this.router.navigate(['/accountview'])
            }
          }
          // this.router.navigate(['/home'])
          
        }//, (error) => {
        //   console.log(error.error.message);
        //   if(error.error.message.match('username')) this.usernameError='Invalid username.';
        //   if(error.error.message.match('password')) this.passwordError='Invalid password.';
        // }
      );
    }
  }

  constructor(private loginService: LoginService, private userState: UserstateService, private router: Router) { }

  ngOnInit(): void {
    this.user = {
      userId:0,
      username:'',
      password:''
    }
  }


}
