import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';

type Course = {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: 'passed' | 'failed' | 'pending';
};

@Component({
  selector: 'app-course-list',
  imports: [CourseCard, NgIf, NgFor],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit, OnDestroy {

  isLoading = true;

  selectedCourseId: number | null = null;

  courses: Course[] = [
    {
      id: 1,
      name: 'Web Development',
      code: 'WD101',
      credits: 4,
      gradeStatus: 'passed'
    },
    {
      id: 2,
      name: 'Database Management',
      code: 'DB201',
      credits: 3,
      gradeStatus: 'pending'
    },
    {
      id: 3,
      name: 'Data Structures',
      code: 'DS301',
      credits: 4,
      gradeStatus: 'failed'
    },
    {
      id: 4,
      name: 'Computer Networks',
      code: 'CN401',
      credits: 3,
      gradeStatus: 'passed'
    },
    {
      id: 5,
      name: 'Operating Systems',
      code: 'OS501',
      credits: 4,
      gradeStatus: 'pending'
    }
  ];

ngOnInit(): void {
  console.log('CourseList initialized');

  setTimeout(() => {
    console.log('Changing loading to false');
    this.isLoading = false;
  }, 1500);
}

  ngOnDestroy(): void {
    console.log('CourseList destroyed');
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}