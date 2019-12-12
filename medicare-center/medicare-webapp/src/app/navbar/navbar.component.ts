import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  person: string;
  loginStatusFlag : boolean = false;

  constructor(private authSer: AuthService) { }

  ngOnInit() {
  }

  userName() {
    return this.person = this.authSer.getuserName();
  }

  loggingOut() {
    this.authSer.logout();
  }

  loginStatus() {
    return this.loginStatusFlag =  this.authSer.isLoggedIn();
  }

}
