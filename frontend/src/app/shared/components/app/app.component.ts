import {Component, OnDestroy, OnInit} from '@angular/core';
import {MdDialog, MdSnackBar} from '@angular/material';
import {ProjectNewModalComponent} from '../project/shared/project-new-modal/project-new-modal.component';
import {ProjectService} from '../../services/project-service/project.service';
import {Project} from '../../../models/project.model';
import {Modal} from '../../../config/modal.config';
import {ErrorService} from '../../services/error-service/error.service';
import {StompService} from '@stomp/ng2-stompjs';
import {Observable, Subscription} from 'rxjs';
import {Message} from '@stomp/stompjs';
import {Task} from 'app/models/task.model';
import {constants} from '../../../constants/app.contstant';
import {element} from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [ProjectService, ErrorService]
})
export class AppComponent implements OnInit, OnDestroy {

  public projects: Project[] = [];

  // Stream of messages
  private projectSubscription: Subscription;
  private projectRemoveSubsciption: Subscription;
  private taskSubscription: Subscription;
  private taskRemoveSubsciption: Subscription;
  // Subscription status
  private subscribed: boolean;

  private WEBSOCKET_PATHES = constants.API.WEBSOCKET.SUBSCRIPTION;

  constructor(private dialog: MdDialog,
              private projectService: ProjectService,
              private _stompService: StompService,
              private snackBar: MdSnackBar) {
  }

  createProject() {
    this.dialog.open(ProjectNewModalComponent, Modal.config);
  }

  ngOnInit(): void {
    this.subscribed = false;
    this.loadAllProjects();
    this.subscribeToWebsocketStream();
  }

  ngOnDestroy(): void {
    this.unsubscribeToWebsocketStream();
  }

  private loadAllProjects(): void {
    this.projectService
      .getAll()
      .then(response => this.projects = response);
  }

  private subscribeToWebsocketStream(): void {
    if (this.subscribed) {
      return;
    }

    this.projectSubscription = this._stompService
      .subscribe(this.WEBSOCKET_PATHES.PROJECT.ONE)
      .subscribe(this.updateProjectCollection.bind(this));

    this.taskSubscription = this._stompService
      .subscribe(this.WEBSOCKET_PATHES.TASK.ONE)
      .subscribe(this.updateTaskList.bind(this));

    this.projectRemoveSubsciption = this._stompService
      .subscribe(this.WEBSOCKET_PATHES.PROJECT.REMOVE)
      .subscribe(this.removeProjectFromCollection.bind(this));


    this.subscribed = true;

  }

  private unsubscribeToWebsocketStream(): void {
    if (!this.subscribed) {
      return;
    }
    // This will internally unsubscribe from Stomp Broker
    // There are two subscriptions - one created explicitly, the other created in the template by use of 'async'
    this.projectSubscription.unsubscribe();
    this.taskSubscription.unsubscribe();
    this.projectRemoveSubsciption.unsubscribe();
    this.projectSubscription = null;
    this.taskSubscription = null;
    this.projectRemoveSubsciption = null;
    this.subscribed = false;
  }

  private updateTaskList(message: Message): void {
    let newTask = JSON.parse(message.body) as Task;
    let project = this.projects.find(project => project.id === newTask.projectId);
    if (project) {
      let index = this.getElementIndex(newTask.id, project.tasks);
      if (index === -1) {
        project.tasks.push(newTask);
      } else {
        project.tasks.splice(index, 1, newTask);
      }

    }


  }

  private removeProjectFromCollection(message: Message): void {

    let projectId = JSON.parse(message.body) as number;
    let index = this.getElementIndex(projectId, this.projects);

    if (index !== -1) {
      this.projects.splice(index, 1);
    }

    this.snackBar.open(`Project with id ${projectId} was removed successfuly`);

  }

  private updateProjectCollection(message: Message): void {
    let project = JSON.parse(message.body) as Project;
    let index = this.getElementIndex(project.id, this.projects);

    if (index === -1) {
      this.projects.push(project);
    } else {
      this.projects.splice(index, 1, project);
    }

  }

  private getElementIndex(elementId: number, collection: any[]): number {
    return collection.findIndex(element => element.id === elementId);
  }

}
