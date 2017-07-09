import {constants} from "../constants/app.contstant";
import {StompConfig} from '@stomp/ng2-stompjs';

/**
 * Created by Viacheslav_Khromoi on 08.07.2017.
 */
export class Stomp {

  static config : StompConfig = {
    //server URL
    url: constants.API.WEBSOCKET.ROOT,

    headers: {
      login: 'guest',
      passcode: 'guest'
    },
    // How often to heartbeat?
    // Interval in milliseconds, set to 0 to disable
    heartbeat_in: 0, // Typical value 0 - disabled
    heartbeat_out: 20000, // Typical value 20000 - every 20 seconds

    // Wait in milliseconds before attempting auto reconnect
    // Set to 0 to disable
    // Typical value 25000 (25 seconds)
    reconnect_delay: 25000,

    // Will log diagnostics on console
    debug: false
  };
}
