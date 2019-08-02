import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
storage;
id: number;
  constructor() { }

  ngOnInit() {
    this.storage = localStorage.getItem("user");
    this.id = JSON.parse(this.storage)[0].id;
  }

}
