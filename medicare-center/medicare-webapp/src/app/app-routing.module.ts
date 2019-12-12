import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import { ChooseRoleComponent } from './choose-role/choose-role.component';
import { AdminComponent } from './admin/admin.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';
import { BookAppoinmentComponent } from './book-appoinment/book-appoinment.component';
import { AuthGuard } from './services/auth.guard';
import { ForgetPasswordComponent } from './site/forget-password/forget-password.component';

const routes: Routes = [
  {path: '', component: ChooseRoleComponent},
  {path: 'choose-role', component: ChooseRoleComponent},
  {path: 'login', component: LoginComponent},
  {path: 'forgetpassword', component: ForgetPasswordComponent},
  {path: 'admin', component: AdminComponent, canActivate : [AuthGuard]},
  {path: 'doctor', component: DoctorComponent, canActivate : [AuthGuard]},
  {path: 'patient', component: PatientComponent, canActivate : [AuthGuard]},
  {path: 'patient/:status', component: PatientComponent, canActivate : [AuthGuard]},
  {path: 'book-appoinment', component: BookAppoinmentComponent, canActivate : [AuthGuard]},
  {path: 'book-appoinment/:id', component: BookAppoinmentComponent, canActivate : [AuthGuard]},
  {path: 'signup', component: SignupComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
