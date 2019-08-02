import { Injectable } from '@angular/core';
import { XMLServiceService } from './xmlservice.service';
import { LoginService } from './loginservice.service';


@Injectable({
  providedIn: 'root'
})
export class RegisterService{
  data;
  register: any;
  constructor(private XMLServiceService: XMLServiceService, private LoginService: LoginService) {  }

  Register(Username, Password, Firstname, Lastname) {
    this.LoginService.loginUrl = ('http://localhost:3000/logins');
    console.log(this.LoginService.loginUrl);
    this.data = {"username": Username, "pass":  Password, "firstname": Firstname, "lastname": Lastname};
    //this.data = {"username": "Luft", "pass": "luft"};
    console.log(this.data);
    this.register = this.XMLServiceService.postXML(this.LoginService.loginUrl, this.data);
    return this.register;
  }
}
