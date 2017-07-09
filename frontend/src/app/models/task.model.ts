/**
 * Created by Viacheslav_Khromoi on 08.07.2017.
 */
export class Task {
  id? : number;
  name? : string;
  deadLineTmstmp?: number;
  isDone? : boolean;
  order? : number;
  projectId? : number;


  constructor(id: number, name: string, deadLineTmstmp: number, isDone: boolean, order: number, projectId: number) {
    this.id = id;
    this.name = name;
    this.deadLineTmstmp = deadLineTmstmp;
    this.isDone = isDone;
    this.order = order;
    this.projectId = projectId;
  }
}
