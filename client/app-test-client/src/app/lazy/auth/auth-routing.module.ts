import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ModalWindowComponent} from './modal-window/modal-window.component';

const routes: Routes = [{
  path: '',
  redirectTo: 'logIn',
  pathMatch: 'full',
}, {
  path: 'logIn',
  component: ModalWindowComponent
}, {
  path: 'signUp',
  component: ModalWindowComponent
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule {
}
