/**
 * Created by Viacheslav_Khromoi on 08.07.2017.
 */

export namespace constants {

  let baseApiPath = "http://localhost:8080/api/v1";
  let baseWebsocketPath = "ws://localhost:8080/api-json/websocket";

  /**
   * API pathes
   */
  export class API {
    static PROJECT = {
      ALL: `${baseApiPath}/project/all`,
      SAVE: `${baseApiPath}/project/save`,
      REMOVE: `${baseApiPath}/project/remove`
    };

    static TASK = {
      SAVE: `${baseApiPath}/task/save`
    };

    static WEBSOCKET = {
      ROOT: baseWebsocketPath,
      SUBSCRIPTION: {
        PROJECT: {
          ONE: '/app/project/new',
          REMOVE: '/app/project/remove'
        },
        TASK: {
          ONE: '/app/task/new'

        }
      },
      BROADCAST: {
        PROJECT: {
          ONE: '/api/v1/project/new',
          REMOVE: '/api/v1/project/remove'
        },
        TASK: {
          ONE: '/api/v1/task/new'
        }
      }

    }

  }

  /**
   * Fields contraints
   */
  export class FIELDS_CONSTRAINTS {

    static PROJECT = {
      MIN_LENGTH: 5,
      MAX_LENGTH: 125,
      MAX_TASK_COUNT: 15
    };

    static TASK = {
      MIN_LENGTH: 5,
      MAX_LENGTH: 125,
    };
  }


}
