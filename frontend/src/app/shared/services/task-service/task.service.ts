import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {ErrorService} from '../error-service/error.service';
import {BaseService} from '../BaseService.interface';
import {constants} from '../../../constants/app.contstant';
import {Task} from '../../../models/task.model';
import * as moment from 'moment';


@Injectable()
export class TaskService implements BaseService{

  private TASK = constants.API.TASK;

  constructor(private http: Http,
              private errorService: ErrorService) {
  }



  save(any: Task): Promise<number> {
    any.deadLineTime = moment(any.deadLineTime).format('Y-MM-DDTHH:mm:ss');
    return this.http
      .post(this.TASK.SAVE, any)
      .toPromise()
      .then(resp => resp.json() as number | Object)
      .catch(this.errorService.handleError);
  }

  getAll(): Promise<any[]> {
    return null;
  }

  remove(any): Promise<number> {
    return null;
  }
}
