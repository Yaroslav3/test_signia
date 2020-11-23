import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ModalWindowComponent} from './modal-window.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  declarations: [
    ModalWindowComponent
  ],
  exports: [
    ModalWindowComponent
  ]
})
export class ModalWindowModule {}
