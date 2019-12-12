import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUserName: string;
  currentRole: string = "anonymous";
  httpOptions: any;

  userLoggedAs: any;

  baseUrl = environment.baseUrl;

  constructor(private httpClient: HttpClient, private authSer: AuthService) {

  }

  getUserLoggedAs() {
    return this.userLoggedAs;
  }
  setUserLoggedAs(userLogged) {
    console.log(userLogged);
    this.userLoggedAs = userLogged;
  }


  /* creating users */


  createUserDoctor(doctorSignupData) {
    console.log('create doc');
    console.log(doctorSignupData);

    return this.httpClient.post(this.baseUrl+"signup-service/medicare/signup/doctor", doctorSignupData);
  }

  createUserPatient(patientSignupData) {
    console.log('create pat');
    console.log(patientSignupData);
    return this.httpClient.post(this.baseUrl+"signup-service/medicare/signup/patient", patientSignupData);
  }

  createUserAdmin(adminSignupData) {
    console.log('create adm');
    console.log(adminSignupData);
    return this.httpClient.post(this.baseUrl+"signup-service/medicare/signup/admin", adminSignupData);
  }

  /* creating users */

  /* update */
  updateUserPatient(patient) {
    return this.httpClient.put(this.baseUrl+"signup-service/medicare/signup/update/patient",patient);
  }

  updateUserDoctor(doctor) {
    return this.httpClient.put(this.baseUrl+"signup-service/medicare/signup/update/doctor",doctor);
  }

  updateUserAdmin(admin) {
    return this.httpClient.put(this.baseUrl+"signup-service/medicare/signup/update/admin",admin);
  }
  /* update */

  /* forgetpassword */
  getSecurityQuestion(name,role) {
    return this.httpClient.get(this.baseUrl+"signup-service/medicare/signup/forgetpwd/"+role+"/"+name);
  }
  /* forget password */


  /* get Request Collection of users */
  getDoctorRequestCollection() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    console.log("doc collection");
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/doctors/requests", this.httpOptions);
  }

  getPatientRequestCollection() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    console.log("pat collection");
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/patients/requests", this.httpOptions);

  }
  /* get request collection of users */


  /* get Collection */

  getDoctorCollection() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    console.log("doc collection");
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/doctors", this.httpOptions);
  }

  getPatientCollection() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    console.log("pat collection");
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/patients", this.httpOptions);
  }

  getMedicareServiceCollection() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    console.log("medicare collection");
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/medicare_services", this.httpOptions);
  }

  getServiceRequests() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    }
    console.log("service request");
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/requests/pendings", this.httpOptions);
  }

  getAllRequestCollection() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    }
    console.log("all request");
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/requests", this.httpOptions);

  }

  /* get Collection */



  /* get accept or reject request */

  patientStatusUpdate(id, status) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.put(this.baseUrl+"medicare-center-service/medicare/patients/" + id + "/" + status, {}, this.httpOptions);
  }

  doctorStatusUpdate(id, status) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.put(this.baseUrl+"medicare-center-service/medicare/doctors/" + id + "/" + status, {}, this.httpOptions);
  }

  serviceStatusUpdate(id, status) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.put(this.baseUrl+"medicare-center-service/medicare/requests/" + id + "/" + status, {}, this.httpOptions);
  }

  requestStatusUpdate(id, status, name) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.put(this.baseUrl+"medicare-center-service/medicare/requests/" + id + "/" + status + "/" + name, {}, this.httpOptions);
  }

  /* get accept or reject request */

  /* get doctors selected service */
  getDoctorServiceCollection(doctorName) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/doctors/" + doctorName, this.httpOptions);
  }
  /* get doctor selected service */

  /* get sevices that are not selected by doctor */
  getDoctorUnselectedServiceCollection(doctorName) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/medicare_services/notselected/" + doctorName, this.httpOptions);
  }
  /* get services that are not selected by doctor */


  /* get accepted doctors for patient */
  getApprovedDoctorsCollection() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/doctors/accepts", this.httpOptions);
  }
  /* get accepted doctors for patient */

  /* get Doctors a list Patient Request for his profile */
  getDoctorsPatientRequest(docName) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/requests/doctors/pendings/" + docName, this.httpOptions);
  }
  /* get Doctors a list Patient Request for his profile */




  /* book app */
  getMedicareById(id) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/medicare_services/" + id, this.httpOptions);
  }

  getPatientByName(userName) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.get(this.baseUrl+"medicare-center-service/medicare/patients/" + userName, this.httpOptions);
  }

  bookAppointment(appoinment) {
    console.log(appoinment);
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.post(this.baseUrl+"medicare-center-service/medicare/request/", appoinment, this.httpOptions);

  }
  /* book app */

  /* add service to doctor */

  addMedicareServiceToDoctor(do_name, me_id) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.put(this.baseUrl+"medicare-center-service/medicare/doctors/service/" + do_name + "/" + me_id, {}, this.httpOptions);
  }

  /* add service to doctor */

  /* add service form */

  addMedicareService(addMedicare) {
    console.log(addMedicare);
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authSer.getToken()
      })
    };
    return this.httpClient.post(this.baseUrl+"medicare-center-service/medicare/medicare_services", addMedicare, this.httpOptions);

  }

  /* add service form */
}
