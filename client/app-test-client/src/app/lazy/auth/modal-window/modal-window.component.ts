import {Component, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {HelperService} from '../../../core/service/helper.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Models} from '../../../core/interface/interface';
import {AuthService} from '../../../core/service/auth.service';

@Component({
  selector: 'app-modal-window',
  templateUrl: './modal-window.component.html',
  styleUrls: ['./modal-window.component.sass']
})
export class ModalWindowComponent implements OnInit {
  public deployPath = environment.deployPath;
  public isLodIn = false;
  public isSignUp = false;
  public profileSignUpForm: FormGroup;
  public profileLogInForm: FormGroup;
  public isErrorEmailRequired = false;
  public isErrorEmailFormat = false;
  public isErrorPasswordEmpty = false;
  public isErrorPasswordNoRepeat = false;
  public isORT = false;
  public valueCode: number;
  public sessionID: string;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private authService: AuthService,
              private helperService: HelperService) {
  }

  ngOnInit(): void {
    this._initFormGroup();
    this.activatedRoute.url.subscribe((event => {
      if (event[0].path.indexOf('logIn')) {
        this.isSignUp = false;
        this.isLodIn = true;
      } else if (event[0].path.indexOf('signUp')) {
        this.isLodIn = false;
        this.isSignUp = true;
      }
    }));
  }


  onBtnSignUp(): void {
    if (this.profileSignUpForm.status === 'VALID') {
      console.log('status', this.profileSignUpForm.status);
    } else {
      if (this.helperService.validateGlobalEmail(this.profileSignUpForm.value.email) === 'error-empty-email') {
        this.isErrorEmailRequired = true;
      } else if (this.helperService.validateGlobalEmail(this.profileSignUpForm.value.email) === 'error-format-email') {
        this.isErrorEmailFormat = true;
      }
      if (this.helperService.validatePassword(this.profileSignUpForm.value.password1, this.profileSignUpForm.value.password2) === 'error-empty-password') {
        this.isErrorPasswordEmpty = true;
        this.isErrorPasswordNoRepeat = false;

      } else if (this.helperService.validatePassword(this.profileSignUpForm.value.password1, this.profileSignUpForm.value.password2) === 'error-no-repeat-password') {
        this.isErrorPasswordEmpty = false;
        this.isErrorPasswordNoRepeat = true;
      }
    }
  }

  onBtnLogIn(): void {
    if (this.profileLogInForm.status === 'VALID') {
      const user: Models.UserAuth = {
        email: this.profileLogInForm.value.email,
        password: this.profileLogInForm.value.password1
      };
      this.getCodeOPT(user);
    } else if (this.helperService.validateGlobalEmail(this.profileLogInForm.value.email) === 'error-empty-email') {
      this.isErrorEmailRequired = true;
    } else if (this.helperService.validateGlobalEmail(this.profileLogInForm.value.email) === 'error-format-email') {
      this.isErrorEmailFormat = true;
    }
    if (!this.profileLogInForm.value.password1 || this.profileLogInForm.value.password1 === '') {
      this.isErrorPasswordEmpty = true;
    }
  }

  onClickInput(): void {
    this.isErrorEmailRequired = false;
    this.isErrorEmailFormat = false;
    this.isErrorPasswordEmpty = false;
    this.isErrorPasswordNoRepeat = false;
  }

  onInputCode(event): void {
    this.valueCode = event.target.value;
  }

  onEnterCode(): void {
    if (this.valueCode) {
      const opt: Models.SessionOpt = {
        code: this.valueCode,
        sessionId: this.sessionID
      };
      this.authService.setCodeOTP(opt).subscribe(data => {
        console.log('Susses', data);
      });
    }
  }

  private _initFormGroup(): void{

    this.profileSignUpForm = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.pattern('^([a-zA-Z0-9_\\+\\.-]+)@([a-zA-Z0-9\\.-]+)\\.([a-zA-Z\\.]{2,6})$')]),
      password1: new FormControl(null , Validators.required),
      password2: new FormControl(null , Validators.required)
    });

    this.profileLogInForm = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.pattern('^([a-zA-Z0-9_\\+\\.-]+)@([a-zA-Z0-9\\.-]+)\\.([a-zA-Z\\.]{2,6})$')]),
      password1: new FormControl(null , Validators.required),
    });
  }

  private getCodeOPT(user: Models.UserAuth): void{
    this.authService.authUser(user).subscribe((data: Models.SessionOpt) => {
      this.sessionID = data.sessionId;
      this.isORT = true;
    });
  }

}
