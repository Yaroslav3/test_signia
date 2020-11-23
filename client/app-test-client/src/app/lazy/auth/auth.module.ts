import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {AuthRoutingModule} from './auth-routing.module';
import {ModalWindowModule} from './modal-window/modal-window.module';

@NgModule({
  imports: [
    CommonModule,
    AuthRoutingModule,
    ModalWindowModule
  ],
  declarations: [
  ],
  exports: [
  ]
})
export class AuthModule {}
