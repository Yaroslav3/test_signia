import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AuthService} from './service/auth.service';
import {SystemService} from './service/system.service';


@NgModule({
  imports: [
    HttpClientModule
  ],
  providers: [
    AuthService,
    SystemService
  ]
})export class CoreModule {}
