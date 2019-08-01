import { Injectable } from '@angular/core';
import { stringify } from '@angular/compiler/src/util';

@Injectable({
  providedIn: 'root'
})
export class XMLServiceService {

  constructor() { }

  getXML(URL: string){
    var xhttp = new XMLHttpRequest();
    var spec = 'username';
    xhttp.onreadystatechange = function(response){
      if(this.status == 200){
        var jsonData = JSON.parse(xhttp.response);
        console.log(jsonData);
        return jsonData;
      }
      else if (this.status >= 400){
        console.log(this.status);
      }
    }
    xhttp.open("GET", URL, true);
      xhttp.send();
  }
}
