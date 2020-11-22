
import {Injectable} from '@angular/core';


@Injectable()
export class SystemService {
  constructor() {
  }

  public getApi(): string {
    return 'http://localhost:8881/';
  }
}
