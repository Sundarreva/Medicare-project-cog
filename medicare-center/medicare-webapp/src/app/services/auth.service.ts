import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = environment.baseUrl;

  private authenticationApiUrl = this.baseUrl+'authentication-service/medicare/authenticate';

  loggedIn: boolean = false;
  token: any;
  role: string;
  userName: string = "Person";
  httpOptions: any;

  signupStatus: boolean = false;


  constructor(private httpClient: HttpClient) {
    this.role = "Anonymous";
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': this.token
      })
    };
  }


  authenticate(user: string, password: string): Observable<any> {
    let credential = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credential);
    return this.httpClient.get(this.authenticationApiUrl, { headers })
  }


  login() {
    this.loggedIn = true;
  }

  logout() {
    this.role = "Anonymous";
    this.userName = "Person";
    this.setToken(null);
    this.setRole(this.role);
    this.loggedIn = false;
  }

  isLoggedIn() {
    return this.loggedIn;
  }

  public setSignupStatus(status) {
    this.signupStatus = status;
  }

  public getSignupStatus() {
    return this.signupStatus;
  }

  /*authentication datas */

  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }

  public setUserName(name: string) {
    this.userName = name;
  }
  public getuserName() {
    return this.userName;
  }

  public setRole(role: string) {
    this.role = role;
  }
  public getRole() {
    return this.role;
  }

  /* authentication datas */



  /* logout() {
    this.userRole = "anonymous";
    this.userSer.setToken(null);
    this.userSer.setRole(this.userRole);
    this.loggedIn = false;
  } */


}
