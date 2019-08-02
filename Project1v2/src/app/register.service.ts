import { Injectable } from '@angular/core';
import { XMLServiceService } from './xmlservice.service';
import { LoginService } from './loginservice.service';


@Injectable({
  providedIn: 'root'
})
export class RegisterService{
  constructor(private XMLServiceService: XMLServiceService, private LoginService: LoginService) {  }

  register(username, password, firstname, lastname) {
    this.LoginService.loginUrl = ('http://localhost:3000/logins?and=(username.eq.' + username + ',pass.eq.' + password + ')');
    console.log(this.LoginService.loginUrl);
    
  }
}
