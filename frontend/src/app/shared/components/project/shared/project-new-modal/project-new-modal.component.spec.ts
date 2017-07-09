import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectNewModalComponent } from './project-new-modal.component';

describe('NewProjectModalComponent', () => {
  let component: ProjectNewModalComponent;
  let fixture: ComponentFixture<ProjectNewModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectNewModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectNewModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
