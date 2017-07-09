import {Component, EventEmitter, Input, OnInit} from '@angular/core';
import {SnackBar} from "../../../../../config/snackbar.config";
import {MdSnackBar} from "@angular/material";
import {WebsocketService} from "../../../../services/websocket-service/websocket.service";
import {Project} from "../../../../../models/project.model";
import {constants} from "../../../../../constants/app.contstant";
import {ProjectService} from "../../../../services/project-service/project.service";


@Component({
  selector: 'app-project-header',
  templateUrl: './project-header.component.html',
  styleUrls: ['./project-header.component.scss'],
  providers: [WebsocketService]
})
export class ProjectHeaderComponent implements OnInit {

  @Input() project: Project;
  @Input() changeProjectName = new EventEmitter<any>();



  public isEdit = false;
  public projectName = "";
  public projectConstraints = constants.FIELDS_CONSTRAINTS.PROJECT;

  constructor(private snackBar: MdSnackBar,
              private websocketService: WebsocketService,
              private projectService: ProjectService) {
  }

  ngOnInit() {}

  saveChanges() {
    this.project.name = this.projectName;
    this.resetChanges();
    this.projectService
      .save(this.project)
      .then((resp => {
        if (isNaN(resp)) {
          // error object
        } else {
          this.snackBar.open("Changes was saved successfully!", null, {duration: 5000});
          this.websocketService.getNewProject(resp);
        }
      }))
  }

  resetChanges() {
    this.isEdit = !this.isEdit;
    this.projectName = "";
  }

  switchEdit() {
    this.projectName = this.project.name;
    this.isEdit = !this.isEdit;
  }

  confirmRemove() {
    this.snackBar
      .open("Remove this project?", "Confirm", SnackBar.config)
      .onAction()
      .subscribe(() => this.websocketService.removeProject(this.project.id));
  }

}
