import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  doctorServiceDatas: any;
  doctorUnselectedServices: any;
  doctorRequestData: any;

  myServiceFlag: boolean;
  serviceRequestFlag: boolean;
  addServiceFlag: boolean;

  accept = 'DOCTOR_ACCEPTED';
  reject = 'DOCTOR_REJECTED';

  constructor(private userSer: UserService, private authSer: AuthService) { }

  ngOnInit() {
    this.myService();
    this.doctorServiceDatas = [];
    this.doctorUnselectedServices = [];
    this.doctorRequestData = [];
  }

  addService() {
    this.addServiceFlag = true;
    this.myServiceFlag = false;
    this.serviceRequestFlag = false;

    this.userSer.getDoctorServiceCollection(this.authSer.getuserName()).subscribe((response) => {
      this.doctorServiceDatas = response;
      console.log(this.doctorServiceDatas);
      this.userSer.getDoctorUnselectedServiceCollection(this.authSer.getuserName()).subscribe((response) => {
        this.doctorUnselectedServices = response;
        console.log(this.doctorUnselectedServices);
      });
    });
  }

  addMedicareToDoctor(me_id) {
    this.userSer.addMedicareServiceToDoctor(this.authSer.getuserName(), me_id).subscribe((response) => {
      //console.log(response);
      this.doctorServiceDatas = response;
      this.userSer.getDoctorUnselectedServiceCollection(this.authSer.getuserName()).subscribe((response) => {
        this.doctorUnselectedServices = response;
        //console.log(this.doctorUnselectedServices);
      });
    });
  }

  serviceRequest() {
    this.serviceRequestFlag = true;
    this.myServiceFlag = false;
    this.addServiceFlag = false;

    this.userSer.getDoctorsPatientRequest(this.authSer.getuserName()).subscribe((request) => {
      this.doctorRequestData = request;
      console.log(this.doctorRequestData);
    });
  }

  myService() {
    this.myServiceFlag = true;
    this.serviceRequestFlag = false;
    this.addServiceFlag = false;

    this.userSer.getDoctorServiceCollection(this.authSer.getuserName()).subscribe((response) => {
      this.doctorServiceDatas = response;
      console.log(this.doctorServiceDatas);
    });
  }

  doctorResponseToServiceRequest(re_id, status) {
    console.log(re_id, status);
    this.userSer.requestStatusUpdate(re_id, status, this.authSer.getuserName()).subscribe((response) => {
      console.log(response);
      this.doctorRequestData = response;
    });

  }

}
