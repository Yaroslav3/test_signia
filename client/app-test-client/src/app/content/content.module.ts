import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ContentComponent} from './content.component';


@NgModule({
  imports: [
    CommonModule,
  ],
  declarations: [
    ContentComponent
  ],
  exports: [
    ContentComponent
  ]
})
export class ContentModule {}
