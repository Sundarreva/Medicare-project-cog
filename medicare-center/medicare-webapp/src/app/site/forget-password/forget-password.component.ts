import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {

  username: string;
  password: string;
  patientData: any;
  errorMessage: string = '';
  errorStatus: boolean = false;
  role: any = '';
  enteredAnswer: any;
  securityQuestion: any;

  forgetPasswordFlag: boolean;
  securityFlag: boolean;
  setPasswordFlag: boolean;

  constructor(private userSer: UserService, private router: Router) { }

  ngOnInit() {
    this.forgetPasswordFlag = true;
    this.securityFlag = false;
  }

  forgotPassword(loginForm: any) {
    this.forgetPasswordFlag = true;
    this.securityFlag = false;
    console.log(loginForm.value);
    this.role = loginForm.value.userRole;
    this.userSer.getSecurityQuestion(loginForm.value.username, loginForm.value.userRole).subscribe((response) => {
      this.patientData = response;
      if(this.patientData == null)
      {
        this.errorMessage = "UserName Not Exist";
      } else {
        console.log("security")
        this.getSecurityquestion();
      }
      console.log(this.patientData);
    });
  }

  getSecurityquestion() {
    this.forgetPasswordFlag = false;
    this.securityFlag = true;
    this.securityQuestion =  this.patientData.securityQuestion;
    this.patientData.securityAnswer;
  }


  securityCheck(securityForm) {
    console.log(securityForm);
    console.log(securityForm.value);
    this.enteredAnswer = securityForm.value.answer
    this.patientData.password = securityForm.value.password;
    if (this.enteredAnswer == this.patientData.securityAnswer) {
      this.errorMessage = "Password changed click to login"
    }
    else {
      this.errorMessage = "Security policy not qualified"
    }
    if(this.role == 'patient') {
      this.userSer.updateUserPatient(this.patientData).subscribe((response) =>  {
        console.log(response);
      });
    } else if(this.role == 'admin') {
      this.userSer.updateUserAdmin(this.patientData).subscribe((response) => {
        console.log(response);
      });
    }
    else if(this.role == 'doctor') {
      this.userSer.updateUserDoctor(this.patientData).subscribe((response) => {
        console.log(response);
      });
    }
  }
}
