import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTaskGeneratorComponent } from './project-task-generator.component';

describe('TaskGeneratorComponent', () => {
  let component: ProjectTaskGeneratorComponent;
  let fixture: ComponentFixture<ProjectTaskGeneratorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTaskGeneratorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTaskGeneratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
