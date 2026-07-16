import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [FormsModule , NgIf],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  // Interpolation
  portalName = 'Student Course Portal';

  // Property Binding
  isPortalActive = true;

  // Event Binding
  message = '';

  // Two-way Binding
  searchTerm = '';

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }
}