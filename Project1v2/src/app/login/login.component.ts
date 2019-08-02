import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule, FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { LoginService} from '../loginservice.service';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
//import { Config } from 'protractor';
import {Login} from '../Login'
import { XMLServiceService } from '../xmlservice.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private LoginService : LoginService, private formBuilder: FormBuilder, private XMLServiceService: XMLServiceService) { }

  loginForm: FormGroup;
  //Login: Config;
  demo: string;
  //login: Login;
  submitted = false;
  loginResponse = "null";
  loading = false;


  get f() { return this.loginForm.controls; }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
  });
    this.demo = 'startup';
    this.LoginService.getall();

    
    

  }

  onSubmit(){
   //todo
   //this.showLogin();
   //this.demo = "onclick works";
   this.submitted = true;
   //window.alert('works');
   if(this.loginForm.invalid){
     return;
   }
   console.log("submitted");
   console.log(this.submitted);
   console.log(this.f.username);
    this.loading = true;
   this.loginResponse = this.LoginService.login(this.f.username.value, this.f.password.value);
   console.log(this.loginResponse);
   //this.LoginService.getLogins();

  //  this.LoginService.login(this.f.username.value, this.f.password.value)
  //  .pipe()
  //  .subscribe(
  //      data => {
  //          console.log(data);
  //      },
  //     );
  }
   //this.demo = (this.Login.firstname);
  }

  //showLogin(){
    //this.LoginService.getLogins().subscribe((data: Login[]) => this.Login[''] = {...data});
   //this.LoginService.getLogins().pipe(first()).subscribe(
     //data => 
     //this.login = data;
   //);
  
   
//}
