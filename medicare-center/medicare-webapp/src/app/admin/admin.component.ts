import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  editMedicare: FormGroup;

  doctorDatas: any;
  patientDatas: any;
  medicareserviceDatas: any;
  serviceRequestDatas: any;
  requestHistoryData: any;
  allDoctorDatas: any;
  allPatientDatas: any;
  allMedicareserviceDatas: any;

  responseId: number;

  doctorFlag: boolean;
  patientFlag: boolean;
  serviceFlag: boolean;
  medicareFlag: boolean;
  requestHistoryFlag: boolean;
  allRequestedData: boolean;
  formSaveStatus: boolean;

  accept = 'ACCEPTED';
  reject = 'REJECTED';

  constructor(private userSer: UserService) { }

  ngOnInit() {
    this.getAllProfiles();
    this.editMedicare = new FormGroup({
      'medicareService': new FormControl('', [Validators.required, Validators.minLength(6)]),
      'serviceDescription': new FormControl('', [Validators.required]),
      'amount': new FormControl('', [Validators.required])
    })
  }


  getReqPatient() {
    this.patientFlag = true;
    this.doctorFlag = false;
    this.serviceFlag = false;
    this.medicareFlag = false;
    this.allRequestedData = false;
    this.formSaveStatus = false;
    this.requestHistoryFlag = false;
    this.userSer.getPatientRequestCollection().subscribe((patients) => {
      this.patientDatas = patients;
      console.log(this.patientDatas);
    });
  }

  getReqDoctor() {
    this.doctorFlag = true;
    this.patientFlag = false;
    this.serviceFlag = false;
    this.medicareFlag = false;
    this.allRequestedData = false;
    this.formSaveStatus = false;
    this.requestHistoryFlag = false;
    this.userSer.getDoctorRequestCollection().subscribe((doctor) => {
      this.doctorDatas = doctor;
      console.log(this.doctorDatas);
    });
  }

  getReqService() {
    this.serviceFlag = true;
    this.patientFlag = false;
    this.doctorFlag = false;
    this.medicareFlag = false;
    this.allRequestedData = false;
    this.formSaveStatus = false;
    this.requestHistoryFlag = false;
    
    this.userSer.getServiceRequests().subscribe((response) => {
      this.serviceRequestDatas = response;
      console.log(this.serviceRequestDatas);
    });

  }

  getMediServices() {
    /* medicareFlag */
    this.medicareFlag = true;
    this.serviceFlag = false;
    this.patientFlag = false;
    this.doctorFlag = false;
    this.allRequestedData = false;
    this.formSaveStatus = false;
    this.requestHistoryFlag = false;
    this.userSer.getMedicareServiceCollection().subscribe((medicare) => {
      this.allMedicareserviceDatas = medicare;
      console.log(this.allMedicareserviceDatas);
    });
  }



  getAllProfiles() {
    this.patientFlag = false;
    this.doctorFlag = false;
    this.serviceFlag = false;
    this.medicareFlag = false;
    this.allRequestedData = true;
    this.formSaveStatus = false;
    this.requestHistoryFlag = false;
    this.userSer.getPatientCollection().subscribe((patients) => {
      this.allPatientDatas = patients;
      console.log(this.allPatientDatas);
    });
    this.userSer.getDoctorCollection().subscribe((doctor) => {
      this.allDoctorDatas = doctor;
      console.log(this.allDoctorDatas);
    });
    this.userSer.getMedicareServiceCollection().subscribe((medicare) => {
      this.allMedicareserviceDatas = medicare;
      console.log(this.allMedicareserviceDatas);
    });
  }

  getRequestHistory() {
    this.requestHistoryFlag = true;
    this.patientFlag = false;
    this.doctorFlag = false;
    this.serviceFlag = false;
    this.medicareFlag = false;
    this.allRequestedData = false;
    this.formSaveStatus = false;

    this.userSer.getAllRequestCollection().subscribe((response) => {
      this.requestHistoryData = response;
    });

  }

  /* submit medicare form */

  addMedicare(editMedicareForm:any){
    console.log(editMedicareForm.value);
    this.userSer.addMedicareService(editMedicareForm.value).subscribe((response)=> {
      console.log(response);
      this.formSaveStatus = true;
      this.userSer.getMedicareServiceCollection().subscribe((medicare) => {
        this.allMedicareserviceDatas = medicare;
        console.log(this.allMedicareserviceDatas);
      });
    });
  }

  /* submit medicare form */



  /* accept or reject request */

  adminResponseToDoctor(do_id, status) {
    this.userSer.doctorStatusUpdate(do_id, status).subscribe((Response) => {
      console.log(Response + "doc");
      this.doctorDatas = Response;
      this.userSer.getDoctorRequestCollection().subscribe((doctor) => {
        this.doctorDatas = doctor;
        console.log(this.doctorDatas);
      });
    });
  }

  adminResponseToPatient(pa_id, status) {
    this.userSer.patientStatusUpdate(pa_id, status).subscribe((Response) => {
      console.log(Response + "pat");
      this.userSer.getPatientRequestCollection().subscribe((patients) => {
        this.patientDatas = patients;
        console.log(this.patientDatas);
      });
    });
  }

  adminResponseToServiceRequest(se_id, status) {
    this.userSer.serviceStatusUpdate(se_id, status).subscribe((response) => {
      console.log(response);
      this.userSer.getServiceRequests().subscribe((response) => {
        this.serviceRequestDatas = response;
        console.log(this.serviceRequestDatas);
      });
    })
    console.log(se_id + " " + status);

  }

}
