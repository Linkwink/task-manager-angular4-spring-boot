import {Component, Input, OnInit} from '@angular/core';
import {Project} from "../../../../../models/project.model";

@Component({
  selector: 'app-project-task-list',
  templateUrl: './project-task-list.component.html',
  styleUrls: ['./project-task-list.component.scss']
})
export class ProjectTaskListComponent implements OnInit {

  @Input() project : Project;

  constructor() { }

  ngOnInit() {
  }

}
