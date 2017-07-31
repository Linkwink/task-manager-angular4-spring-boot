/**
 * Created by Viacheslav_Khromoi on 08.07.2017.
 */
export class Task {
  id? : number;
  name? : string;
  deadLineTime?: string;
  isDone? : boolean;
  order? : number;
  projectId? : number;


  constructor(id: number, name: string, deadLineTmstmp: string, isDone: boolean, order: number, projectId: number) {
    this.id = id;
    this.name = name;
    this.deadLineTime = deadLineTmstmp;
    this.isDone = isDone;
    this.order = order;
    this.projectId = projectId;
  }
}
