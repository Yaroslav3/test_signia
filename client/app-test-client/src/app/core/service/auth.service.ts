import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {SystemService} from './system.service';
import {Models} from '../interface/interface';
import {Observable} from 'rxjs';
import * as apiConstants from '../../core/api-constants';


@Injectable()
export class AuthService {
  constructor(private _HTTP: HttpClient,
              private _SYSTEM: SystemService) {
  }

  public authUser(auth: Models.UserAuth): Observable<object>{
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json; charset=utf-8');
    return this._HTTP.post<object>(this._SYSTEM.getApi() + apiConstants.AUTH, auth, { headers});
  }
}
