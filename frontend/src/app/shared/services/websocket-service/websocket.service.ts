import {Injectable} from '@angular/core';
import {StompService} from '@stomp/ng2-stompjs';
import {constants} from "../../../constants/app.contstant";

@Injectable()
export class WebsocketService {

  private WEBSOCKET_PATHES = constants.API.WEBSOCKET.BROADCAST;

  constructor(private _stompService: StompService) {
  }

  getNewProject(id: number) {
    this._stompService.publish(this.WEBSOCKET_PATHES.PROJECT.ONE, id.toString());
  }

  removeProject(id: number) {
    this._stompService.publish(this.WEBSOCKET_PATHES.PROJECT.REMOVE, id.toString());
  }

  getNewTask(id: number) {
    this._stompService.publish(this.WEBSOCKET_PATHES.TASK.ONE, id.toString());
  }
}
