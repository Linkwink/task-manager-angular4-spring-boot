import {Component, OnInit} from '@angular/core';
import {MdDialog, MdSnackBar} from '@angular/material'
import {SnackBar} from '../../../../../config/snackbar.config'
import {ProjectService} from 'app/shared/services/project-service/project.service'
import {Project} from '../../../../../models/project.model'
import {constants} from '../../../../../constants/app.contstant'
import {ErrorService} from '../../../../services/error-service/error.service'
import {WebsocketService} from '../../../../services/websocket-service/websocket.service'

@Component({
  selector: 'project-new-modal',
  templateUrl: './project-new-modal.component.html',
  styleUrls: ['./project-new-modal.component.scss'],
  providers: [ProjectService, ErrorService, WebsocketService]
})
export class ProjectNewModalComponent {

  public projectName = '';
  public projectConstraints = constants.FIELDS_CONSTRAINTS.PROJECT;


  constructor(private projectService: ProjectService,
              private dialog: MdDialog,
              private snackBar: MdSnackBar,
              private websocketService: WebsocketService) {
  }


  confirmClose() {
    this.snackBar
      .open('Cancel creation?', 'Confirm', SnackBar.config)
      .onAction()
      .subscribe(() => this.dialog.closeAll());
  }

  createProject() {
    this.projectService
      .save({name: this.projectName} as Project)
      .then((resp => {
        if (isNaN(resp)) {
          // error object
        } else {
          this.snackBar.open('Success!', null,{ duration : 5000 });
          this.websocketService.getNewProject(resp);
        }
      }))
  }

}
