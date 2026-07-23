import { Component } from '@angular/core';
import { CourseListComponent } from './components/course-list/course-list';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CourseListComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent {

}