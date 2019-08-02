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
    var jsonData;
    xhttp.onreadystatechange = function(response){
      if(this.status == 200){
        if(this.readyState == 4){
        jsonData = JSON.parse(xhttp.response);
        
        }
      }
      else if (this.status >= 400){
        console.log(this.status);
        return this.status;
      }
      console.log(jsonData);
        return jsonData;
    }
    xhttp.open("GET", URL, true);
      xhttp.send();
      
  }
}
