import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: any;
  errorMsg: string;

  signupStatus: boolean;

  constructor(private authSer: AuthService, private router: Router) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      'username': new FormControl(),
      'password': new FormControl()
    });
    this.signupStatus = this.authSer.getSignupStatus();
  }

  ngOnDestroy() {
    this.authSer.setSignupStatus(false);
  }


  loggingIn(loginData) {

    this.authSer.authenticate(loginData.username, loginData.password)
      .subscribe((response) => {
        console.log(response);
        this.authSer.setRole(response.role);
        this.authSer.setUserName(response.user);
        this.authSer.setToken(response.token);
        this.authSer.login();
        
        console.log("logged in");
        if(response.role == "ROLE_ADMIN") {
        this.router.navigate(['admin']);
        }
        if(response.role == "ROLE_PATIENT") {
          this.router.navigate(['patient']);
        }
        if(response.role == "ROLE_DOCTOR") {
          this.router.navigate(['doctor']);
        }
      },
      (error) => {
        console.log(error);
        if(error.error == null) {
          this.errorMsg = "Invalid Username/Password"
        }
        else {
          if(error.error.errorMessage == "Your Request is Pending") {
            this.errorMsg = "Your Signup Request is Pending"
          }
          else {
            this.errorMsg = "Your Signup Request is Rejected"
          }
        }
      });

  }



}
