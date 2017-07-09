/**
 * Created by Viacheslav_Khromoi on 08.07.2017.
 */

export interface BaseService {
   save(any) : Promise<number>;
   getAll(): Promise<any[]>;
   remove(any): Promise<number>;
}
