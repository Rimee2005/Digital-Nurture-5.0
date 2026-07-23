import { Component, OnInit, inject } from '@angular/core';

import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  Validators
} from '@angular/forms';

import { CommonModule } from '@angular/common';


// Custom synchronous validator
// Rejects course codes starting with "XX"
function noCourseCode(control: AbstractControl): ValidationErrors | null {

  const value = control.value;

  if (value && value.toString().startsWith('XX')) {
    return { noCourseCode: true };
  }

  return null;
}


// Custom asynchronous validator
// Simulates checking whether an email is already taken
function simulateEmailCheck(
  control: AbstractControl
): Promise<ValidationErrors | null> {

  return new Promise((resolve) => {

    setTimeout(() => {

      const email = control.value;

      if (email && email.includes('test@')) {

        resolve({ emailTaken: true });

      } else {

        resolve(null);

      }

    }, 800);

  });

}


@Component({
  selector: 'app-reactive-enrollment-form',

  standalone: true,

  imports: [
    CommonModule,
    ReactiveFormsModule
  ],

  templateUrl: './reactive-enrollment-form.html',

  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentFormComponent implements OnInit {


  private fb = inject(FormBuilder);


  enrollForm!: FormGroup;


  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],


      studentEmail: [

        '',

        [
          Validators.required,
          Validators.email
        ],

        [
          simulateEmailCheck
        ]

      ],


      courseId: [

        null,

        [
          Validators.required,
          noCourseCode
        ]

      ],


      preferredSemester: [

        'Odd',

        Validators.required

      ],


      agreeToTerms: [

        false,

        Validators.requiredTrue

      ],


      additionalCourses: this.fb.array([])

    });

  }


  /*
   FormArray allows us to dynamically add or remove
   multiple form controls.
  */

  get additionalCourses(): FormArray {

    return this.enrollForm.get(
      'additionalCourses'
    ) as FormArray;

  }


  addCourse(): void {

    this.additionalCourses.push(

      new FormControl(
        '',
        Validators.required
      )

    );

  }


  removeCourse(index: number): void {

    this.additionalCourses.removeAt(index);

  }


  onSubmit(): void {

    if (this.enrollForm.valid) {


      console.log(
        'Form Value:',
        this.enrollForm.value
      );


      /*
       enrollForm.value:
       Excludes disabled controls.

       enrollForm.getRawValue():
       Includes disabled controls as well.
      */

      console.log(

        'Raw Form Value:',

        this.enrollForm.getRawValue()

      );

    }

  }

}