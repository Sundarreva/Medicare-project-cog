import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Patient } from './Patient';
import { Router } from '@angular/router';
import { Doctor } from './doctor';
import { Admin } from './admin';
import { AuthService } from 'src/app/services/auth.service';
 
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  gender: any[];
  securityQues: any[];
  flagForFields : boolean;
  choosenUser: string;
  errorMsg: string;

  signupStatus: boolean;

  patientForm: Patient = {
    firstName: null,
    lastName: null,
    age: null,
    dateOfBirth: null,
    gender: null,
    userName: null,
    contactNumber: null,
    altContactNumber: null,
    emailId: null,
    password: null,
    addressLineOne: null,
    addressLineTwo: null,
    city: null,
    state: null,
    zipCode: null,
    securityQuestion: null,
    securityAnswer: null
  };

  doctorForm: Doctor = {
    firstName: null,
    lastName: null,
    age: null,
    dateOfBirth: null,
    gender: null,
    userName: null,
    contactNumber: null,
    altContactNumber: null,
    emailId: null,
    password: null,
    addressLineOne: null,
    addressLineTwo: null,
    city: null,
    state: null,
    zipCode: null,
    degree: null,
    speciality: null,
    workHours: null,
    hospitalName: null,
    securityQuestion: null,
    securityAnswer: null
  }

  adminForm: Admin = {
    userName: null,
    firstName: null,
    lastName: null,
    age: null,
    gender: null,
    dateOfBirth: null,
    contactNumber: null,
    altContactNumber: null,
    emailId: null,
    password: null,
    securityQuestion: null,
    securityAnswer: null
  }

  constructor(private userSer: UserService, private authSer: AuthService, private router: Router) {
    this.gender = ["Male","Female","Other"];
    this.securityQues = ["What is you pet name", "Which is your favorite place", "Which is your favourite food"]
   }


  ngOnInit() {
    
  }

  onClick(formValid) {
    this.flagForFields = !formValid;
    console.log("click");
  }

  userAs() {
    return this.choosenUser = this.userSer.getUserLoggedAs();
  }

  onSubmitPatient(patient) {
    console.log('on sumbit filedflag'+ this.flagForFields);
    if(this.flagForFields == false) {
    this.patientForm.firstName = patient.Pat_firstname;
    this.patientForm.lastName = patient.Pat_lastname;
    this.patientForm.age = patient.Pat_age;
    this.patientForm.dateOfBirth = patient.Pat_dateofbirth;
    this.patientForm.gender = patient.Pat_gender;
    this.patientForm.userName = patient.Pat_username;
    this.patientForm.contactNumber = patient.Pat_contactnumber;
    this.patientForm.altContactNumber = patient.Pat_altcontactnumber;
    this.patientForm.emailId = patient.Pat_emailid;
    this.patientForm.password = patient.Pat_password;
    this.patientForm.addressLineOne = patient.Pat_address1;
    this.patientForm.addressLineTwo = patient.Pat_address2;
    this.patientForm.city = patient.Pat_city;
    this.patientForm.state = patient.Pat_state;
    this.patientForm.zipCode = patient.Pat_zipcode;
    this.patientForm.securityQuestion = patient.Pat_securityQuestion;
    this.patientForm.securityAnswer = patient.Pat_securityAnswer;
    console.log("creating")
    this.userSer.createUserPatient(this.patientForm).subscribe((data)=>{
      this.authSer.setSignupStatus(true);
      this.router.navigate(['/login']);  
    },
      (error) => {
        console.log(error);
        if(error.error.errorMessage == "User already Exist") {
          this.errorMsg = "User Name has already registred try new name";
        }
      }
    );
    }
  }

  onSubmitDoctor(doctor) {
    console.log("submit doctor");
    console.log(doctor.Doc_address1);

    if(this.flagForFields == false) {
      this.doctorForm.firstName = doctor.Doc_firstname;
      this.doctorForm.lastName = doctor.Doc_lastname;
      this.doctorForm.age = doctor.Doc_age;
      this.doctorForm.dateOfBirth = doctor.Doc_dateofbirth;
      this.doctorForm.gender = doctor.Doc_gender;
      this.doctorForm.userName = doctor.Doc_username;
      this.doctorForm.contactNumber = doctor.Doc_contactnumber;
      this.doctorForm.altContactNumber = doctor.Doc_altcontactnumber;
      this.doctorForm.emailId = doctor.Doc_emailid;
      this.doctorForm.password =  doctor.Doc_password;
      this.doctorForm.addressLineOne = doctor.Doc_address1;
      this.doctorForm.addressLineTwo =  doctor.Doc_address2;
      this.doctorForm.city = doctor.Doc_city;
      this.doctorForm.state = doctor.Doc_state;
      this.doctorForm.zipCode =  doctor.Doc_zipcode;
      this.doctorForm.degree = doctor.Doc_degree;
      this.doctorForm.speciality = doctor.Doc_speciality;
      this.doctorForm.workHours = doctor.Doc_workhours;
      this.doctorForm.hospitalName = doctor.Doc_hospitalname;
      this.doctorForm.securityQuestion = doctor.Doc_securityQuestion;
      this.doctorForm.securityAnswer = doctor.Doc_securityAnswer;
      console.log(this.doctorForm);
      console.log('creating');
      this.userSer.createUserDoctor(this.doctorForm).subscribe((data)=>{
        this.authSer.setSignupStatus(true);
        this.router.navigate(['/login']);  
      },
      (error) => {
        console.log(error);
        if(error.error.errorMessage == "User already Exist") {
          this.errorMsg = "User Name has already registred try new name";
        }
      }
      );
      }
      //this.router.navigate(['/login']);
  }

  onSubmitAdmin(admin) {
    console.log("submit admin");

    if(this.flagForFields == false) {
      this.adminForm.firstName = admin.Ad_firstname;
      this.adminForm.lastName = admin.Ad_lastname;
      this.adminForm.age = admin.Ad_age;
      this.adminForm.gender = admin.Ad_gender;
      this.adminForm.userName = admin.Ad_username;
      this.adminForm.dateOfBirth = admin.Ad_dateofbirth;
      this.adminForm.contactNumber = admin.Ad_contactnumber;
      this.adminForm.altContactNumber = admin.Ad_altcontactnumber;
      this.adminForm.emailId = admin.Ad_emailid;
      this.adminForm.password  = admin.Ad_password;
      this.adminForm.securityQuestion = admin.Ad_securityQuestion;
      this.adminForm.securityAnswer = admin.Ad_securityAnswer;
      console.log(this.adminForm);
      console.log("creating")
    this.userSer.createUserAdmin(this.adminForm).subscribe((data)=>{
      this.authSer.setSignupStatus(true);
      this.router.navigate(['/login']);  
    },
    (error) => {
      console.log(error);
      if(error.error.errorMessage == "User already Exist") {
        this.errorMsg = "User Name has already registred try new name";
      }
    }
    );
    }
  }

}
