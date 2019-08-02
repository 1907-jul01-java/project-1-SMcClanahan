import { Injectable } from '@angular/core';
import { XMLServiceService } from './xmlservice.service';
import { stringify } from 'querystring';
import { Router } from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class LoginService {
  user: any;
  err: string;
  loginUrl: string;
  
  
  constructor(private XMLServiceService :XMLServiceService, private router: Router ) { }

login(Username, Password) {
  this.loginUrl = ('http://localhost:3000/logins?and=(username.eq.' + Username + ',pass.eq.' + Password + ')');
  console.log(this.loginUrl);
  this.XMLServiceService.getXML(this.loginUrl).then(function(Obj){
    console.log(Obj);
    localStorage.setItem("user", JSON.stringify(Obj));
    return Obj;
  }, function(error){
      window.alert('Login failed');
    }
    
    // console.log(response[1].username);
    // console.log(response[0].pass);
      
  );
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
