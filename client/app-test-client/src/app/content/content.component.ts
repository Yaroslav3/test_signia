import {Component, OnInit} from '@angular/core';
import {AuthService} from '../core/service/auth.service';
import {Models} from '../core/interface/interface';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.sass']
})
export class ContentComponent implements OnInit {
  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    const user: Models.UserAuth = {
      email: 'foo@bar.baz',
      password: '123123'
    };
    this.authService.authUser(user).subscribe((data => {
      console.log('test', data);
    }));
  }
}
