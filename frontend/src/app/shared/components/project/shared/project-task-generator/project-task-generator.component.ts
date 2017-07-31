import {Component, Input, OnInit} from '@angular/core';
import {constants} from '../../../../../constants/app.contstant'
import {Task} from 'app/models/task.model'
import {Project} from '../../../../../models/project.model'
import {TaskService} from '../../../../services/task-service/task.service'
import {WebsocketService} from '../../../../services/websocket-service/websocket.service'
import {MdSnackBar} from '@angular/material'

@Component({
  selector: 'app-project-task-generator',
  templateUrl: './project-task-generator.component.html',
  styleUrls: ['./project-task-generator.component.scss'],
  providers: [TaskService, WebsocketService]
})
export class ProjectTaskGeneratorComponent implements OnInit {

  @Input() project: Project;


  public newTask: Task;
  public minDeadlineTime = new Date();
  public taskConstraints = constants.FIELDS_CONSTRAINTS.TASK;

  constructor(private taskService : TaskService,
              private snackBar: MdSnackBar,
              private websocketService: WebsocketService) {
  }

  ngOnInit() {
    this.createEmptyTask();
  }

  addTask() {
    this.taskService
      .save(this.newTask as Task)
      .then( resp => {
        if (isNaN(resp)) {
          // error object
        } else {
          this.snackBar.open('Task created!', null,{ duration : 5000 });
          this.websocketService.getNewTask(resp);
        }
        this.createEmptyTask();
      });
  }

  private createEmptyTask(): void {
    this.newTask = new Task(null, '', null, false, 0, this.project.id);
  }

}
