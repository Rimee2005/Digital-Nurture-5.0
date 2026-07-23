import { Routes } from '@angular/router';

import { ReactiveEnrollmentFormComponent } from
  './pages/reactive-enrollment-form/reactive-enrollment-form';


export const routes: Routes = [

  {
    path: 'enroll-reactive',

    component: ReactiveEnrollmentFormComponent

  },


  {
    path: '',

    redirectTo: 'enroll-reactive',

    pathMatch: 'full'

  }

];