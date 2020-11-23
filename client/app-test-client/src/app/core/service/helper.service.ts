import {Injectable} from '@angular/core';

@Injectable()
export class HelperService {
  constructor() {
  }

  public validateGlobalEmail(email: string): string {
    const pattern = new RegExp('^([a-zA-Z0-9_\\+\\.-]+)@([a-zA-Z0-9\\.-]+)\\.([a-zA-Z\\.]{2,6})$');

    if (!email || email === '') {
      return 'error-empty-email';
    }
    if (!pattern.test(email)) {
      return 'error-format-email';
    }
    return 'VALID';
  }

  public validatePassword(pass1: string, pass2: string): string {
    if ((!pass1 || pass1 === '') || (!pass2 || pass2 === '')) {
      return 'error-empty-password';
    }
    if (pass1 !== pass2) {
      return 'error-no-repeat-password';
    }
  }
}
