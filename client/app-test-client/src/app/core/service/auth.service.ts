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

  public authUser(auth: Models.UserAuth): Observable<Models.SessionOpt>{
    return this._HTTP.post<Models.SessionOpt>(this._SYSTEM.getApi() + apiConstants.AUTH, auth);
  }

  public setCodeOTP(otp: Models.SessionOpt): Observable<string> {
    return this._HTTP.post<string>(this._SYSTEM.getApi() + apiConstants.OTP, otp);
  }

}
