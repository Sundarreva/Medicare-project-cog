import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-choose-role',
  templateUrl: './choose-role.component.html',
  styleUrls: ['./choose-role.component.css']
})
export class ChooseRoleComponent implements OnInit {

  constructor(private userSer: UserService, private route: Router) { }

  ngOnInit() {
  }

  loggingAsPatient() {
    this.userSer.setUserLoggedAs("patient");
    this.route.navigate(['/signup']);
  }

  loggingAsDoctor() {
    this.userSer.setUserLoggedAs("doctor");
    this.route.navigate(['/signup']);
  }

  loggingAsAdmin() {
    this.userSer.setUserLoggedAs("admin");
    this.route.navigate(['/signup']);
  }


}
