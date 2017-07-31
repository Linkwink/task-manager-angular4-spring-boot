import {Component, OnInit, Input} from '@angular/core';
import {Task} from "../../../models/task.model";
@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {

  @Input() task: Task;
  public checked: boolean = false;

  constructor() {
  }

  ngOnInit() {
  }

}
