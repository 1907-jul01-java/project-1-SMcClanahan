import { Injectable } from '@angular/core';
import { XMLServiceService } from './xmlservice.service';



@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private XMLServiceService :XMLServiceService ) { }

  loginUrl = 'http://localhost:3000/logins?select=username';

login(username, password) {
  
}


}

