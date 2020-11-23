import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ContentComponent} from './content.component';
import {RouterModule} from '@angular/router';


@NgModule({
  imports: [
    CommonModule,
    RouterModule,
  ],
  declarations: [
    ContentComponent
  ],
  exports: [
    ContentComponent
  ]
})
export class ContentModule {}
