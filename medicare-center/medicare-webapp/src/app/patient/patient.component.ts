import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { UserService } from '../services/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  doctorsList: any;
  medicareList: any;

  doctorFlag: boolean;

  bookingStatus: string;


  constructor(private userSer: UserService, private route: Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.bookingStatus = params.get('status');
    })
    this.getMedicare();
  }

  getDoctors() {
    console.log("getDoctors()");
    this.doctorFlag = true;
    this.userSer.getApprovedDoctorsCollection().subscribe((response) => {
      this.doctorsList = response;
      console.log(this.doctorsList);
    })
  }

  getMedicare() {
    this.doctorFlag = false;
    this.userSer.getMedicareServiceCollection().subscribe((response) => {
      this.medicareList = response;
      console.log(this.medicareList);
    })

  }

  bookAppointment(medicareId: any) {
    this.route.navigate(['book-appoinment', medicareId]); 
  }

}
