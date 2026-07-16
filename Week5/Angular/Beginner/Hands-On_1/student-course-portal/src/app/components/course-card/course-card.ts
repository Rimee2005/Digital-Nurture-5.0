import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';

@Component({
  selector: 'app-course-card',
  imports: [],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {

  @Input() course!: {
    id: number;
    name: string;
    code: string;
    credits: number;
  };

  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges): void {
    console.log(
      'Previous value:',
      changes['course']?.previousValue
    );

    console.log(
      'Current value:',
      changes['course']?.currentValue
    );
  }

  onEnroll(): void {
    this.enrollRequested.emit(this.course.id);
  }
}