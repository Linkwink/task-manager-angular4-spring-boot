import {Injectable} from '@angular/core';
import {Http} from '@angular/http'
import {BaseService} from '../BaseService.interface'
import {constants} from '../../../constants/app.contstant'
import {Project} from '../../../models/project.model'
import 'rxjs/add/operator/toPromise';
import {ErrorService} from '../error-service/error.service'

@Injectable()
export class ProjectService implements BaseService {

  private PROJECT = constants.API.PROJECT;

  constructor(private http: Http,
              private errorService: ErrorService) {
  }


  save(any): Promise<number> {
    return this.http
      .post(this.PROJECT.SAVE, any)
      .toPromise()
      .then(resp => resp.json() as number | object)
      .catch(this.errorService.handleError);
  }

  remove(any): Promise<number> {
    return null;
  }

  getAll(): Promise<any[]> {
    return this.http
      .get(this.PROJECT.ALL)
      .toPromise()
      .then(resp => resp.json() as Project[])
      .catch(this.errorService.handleError);
  }


}
