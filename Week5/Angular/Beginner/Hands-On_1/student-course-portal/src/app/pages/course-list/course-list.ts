import { Component } from '@angular/core';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  imports: [CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList {

  courses = [
    {
      id: 1,
      name: 'Web Development',
      code: 'WD101',
      credits: 4
    },
    {
      id: 2,
      name: 'Database Management',
      code: 'DB201',
      credits: 3
    },
    {
      id: 3,
      name: 'Data Structures',
      code: 'DS301',
      credits: 4
    },
    {
      id: 4,
      name: 'Computer Networks',
      code: 'CN401',
      credits: 3
    },
    {
      id: 5,
      name: 'Operating Systems',
      code: 'OS501',
      credits: 4
    }
  ];

  selectedCourseId: number | null = null;

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);

    this.selectedCourseId = courseId;
  }
}