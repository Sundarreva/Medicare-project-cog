import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { UserService } from '../services/user.service';
import { stringify } from 'querystring';

@Component({
  selector: 'app-book-appoinment',
  templateUrl: './book-appoinment.component.html',
  styleUrls: ['./book-appoinment.component.css']
})
export class BookAppoinmentComponent implements OnInit {

  medicareData: any;
  patientData: any;
  medid: any;


  constructor(private authSer: AuthService, private userSer: UserService, private route: Router, private activatedRoute: ActivatedRoute, ) {

  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.medid = params.get('id');
      this.userSer.getMedicareById(this.medid).subscribe((response) => {
        this.medicareData = response;
        console.log(this.medicareData);
      });
    })

  }

  bookAppointmentMethod(bookAppointmentForm) {
    let user = this.authSer.getuserName();
    this.userSer.getPatientByName(user).subscribe((response) => {
      this.patientData = response;
      let bookAppointmentData = {
        approve: "PENDING",
        dateOfAppointment: bookAppointmentForm.Bo_date,
        patient: this.patientData,
        doctor: bookAppointmentForm.Bo_doctor,
        medicareService: this.medicareData
      }
      //console.log(bookAppointmentData);
      this.userSer.bookAppointment(bookAppointmentData).subscribe((response) => {
        console.log(response);
        this.route.navigate(['/patient',"booked"]);
      });
    });
  }

}

