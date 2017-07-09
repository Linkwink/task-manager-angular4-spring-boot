import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {ErrorService} from "../error-service/error.service";
import {BaseService} from "../BaseService.interface";
import {constants} from "../../../constants/app.contstant";

@Injectable()
export class TaskService implements BaseService{

  private TASK = constants.API.TASK;

  constructor(private http: Http,
              private errorService: ErrorService) {
  }


  save(any): Promise<number> {
    return this.http
      .post(this.TASK.SAVE, any)
      .toPromise()
      .then(resp => resp.json() as number | object)
      .catch(this.errorService.handleError);
  }

  getAll(): Promise<any[]> {
    return null;
  }

  remove(any): Promise<number> {
    return null;
  }
}
