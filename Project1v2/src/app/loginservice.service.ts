import { Injectable } from '@angular/core';
import { XMLServiceService } from './xmlservice.service';
import { stringify } from 'querystring';



@Injectable({
  providedIn: 'root'
})
export class LoginService {
  user: any;
  err: string;
  loginUrl: string;
  constructor(private XMLServiceService :XMLServiceService ) { }

login(username, password) {
  this.loginUrl = ('http://localhost:3000/logins?and=(username.eq.' + username + ',pass.eq.' + password + ')');
  console.log(this.loginUrl);
  this.user = this.XMLServiceService.getXML(this.loginUrl);
  if((this.user = username)){
  localStorage.setItem('currentUser', JSON.stringify(this.user));
  return this.user;
  }
  else{
    console.log('login failed');
  }
}

getall(){
  this.loginUrl = "http://localhost:3000/logins";
  this.user = this.XMLServiceService.getXML(this.loginUrl);
  if(!(this.user >= 400)){
  localStorage.setItem('currentUser', JSON.stringify(this.user));
  return this.user;
  }
  else{
    console.log('login failed');
    this.err = 'Login failed';
  }
}


}

