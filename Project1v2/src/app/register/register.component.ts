import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  registerResponse = "null";
  constructor(private FormBuilder: FormBuilder,
    private router: Router, private RegisterService: RegisterService) { }

  ngOnInit() {
    this.registerForm = this.FormBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]
  });
  }

  get f() { return this.registerForm.controls; }

onSubmit(){
  this.submitted = true;
  if(this.registerForm.invalid){
    return;
  }
  console.log(this.f.password);
  this.registerResponse = this.RegisterService.Register(this.f.username.value, this.f.password.value, this.f.firstName.value, this.f.lastName.value);
  console.log(this.registerResponse);
}
}
