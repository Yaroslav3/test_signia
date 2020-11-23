import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';


export const routes: Routes = [{
  path: '',
  redirectTo: 'auth',
  pathMatch: 'full'
}, {
  path: 'auth',
  data: {title: 'auth'},
  loadChildren: () => import('./lazy/auth/auth.module').then(m => m.AuthModule)
}];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
