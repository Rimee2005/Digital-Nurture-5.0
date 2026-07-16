import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [FormsModule, NgIf],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit, OnDestroy {

  portalName = 'Student Course Portal';

  isPortalActive = true;

  message = '';

  searchTerm = '';

  availableCourses = 0;

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }

  ngOnInit(): void {
    this.availableCourses = 12;

    console.log(
      'HomeComponent initialised — courses loaded'
    );
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }
}