import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AuthService} from './service/auth.service';
import {SystemService} from './service/system.service';
import {HelperService} from './service/helper.service';


@NgModule({
  imports: [
    HttpClientModule
  ],
  providers: [
    AuthService,
    SystemService,
    HelperService
  ]
})export class CoreModule {}
