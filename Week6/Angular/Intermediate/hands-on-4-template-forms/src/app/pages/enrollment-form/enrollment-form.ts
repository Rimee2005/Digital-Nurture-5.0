import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,

  // FormsModule enables:
  // [(ngModel)]
  // #enrollForm="ngForm"
  // #nameCtrl="ngModel"
  imports: [FormsModule, CommonModule],

  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css'
})
export class EnrollmentFormComponent {

  submitted = false;

  studentName = '';
  studentEmail = '';
  courseId: number | null = null;
  preferredSemester = '';
  agreeToTerms = false;


  onSubmit(form: NgForm): void {

    // Check whether the form is valid
    if (form.valid) {

      this.submitted = true;

      console.log('Form Value:', form.value);
      console.log('Form Valid:', form.valid);

    } else {

      this.submitted = false;

      console.log('Form is invalid');

    }
  }


  resetForm(form: NgForm): void {

    form.resetForm();

    this.submitted = false;

  }

}