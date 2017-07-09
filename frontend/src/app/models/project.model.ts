import {Task} from "./task.model";

/**
 * Created by Viacheslav_Khromoi on 08.07.2017.
 */

export class Project {
  id? : number;
  name : string;
  tasks : Task[];


  constructor(id: number, name: string, tasks: Task[]) {
    this.id = id;
    this.name = name;
    this.tasks = tasks;
  }
}
