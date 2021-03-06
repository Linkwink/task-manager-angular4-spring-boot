import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTaskListComponent } from './project-task-list.component';

describe('TaskListComponent', () => {
  let component: ProjectTaskListComponent;
  let fixture: ComponentFixture<ProjectTaskListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTaskListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTaskListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
