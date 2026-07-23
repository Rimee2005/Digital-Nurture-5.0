import { Component, OnInit } from '@angular/core';
import { CourseCardComponent } from '../course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {

  isLoading = true;

  courses = [
    {
      id: 1,
      name: 'Angular',
      instructor: 'John Doe',
      credits: 3,
      gradeStatus: 'passed',
      enrolled: true
    },
    {
      id: 2,
      name: 'Java',
      instructor: 'Jane Smith',
      credits: 4,
      gradeStatus: 'failed',
      enrolled: false
    },
    {
      id: 3,
      name: 'Database Management',
      instructor: 'Robert Brown',
      credits: 2,
      gradeStatus: 'pending',
      enrolled: false
    }
  ];

  ngOnInit(): void {

    // Simulating API loading time
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  // trackBy helps Angular identify items by their unique ID.
  // Therefore, Angular updates only changed items instead of re-rendering the entire list.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}