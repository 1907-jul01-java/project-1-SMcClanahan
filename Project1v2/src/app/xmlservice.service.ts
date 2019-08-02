import { Injectable } from '@angular/core';
import { stringify } from '@angular/compiler/src/util';
import { getLocaleNumberFormat } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class XMLServiceService {

  constructor() { }

  getXML(URL: string){
    
    var spec = 'username';
    var jsonData;

    return new Promise(function(resolve,reject){
      var xhttp = new XMLHttpRequest();
      xhttp.onload = function(){
        if(this.status == 200){
         var Obj = JSON.parse(xhttp.response);
          resolve(Obj);
        }
        else{
          reject(console.error(xhttp.statusText));
        }
      }
      xhttp.open("GET", URL, false);
      xhttp.send();
    });
    // xhttp.onreadystatechange = function(response){
    //   if(this.status == 200){
    //     if(this.readyState == 4){
    //     jsonData = JSON.parse(xhttp.response);
        
    //     }
    //   }
    //   else if (this.status >= 400){
    //     console.log(this.status);
    //     return this.status;
    //   }
    //   console.log(jsonData);
    //     return jsonData;
    // }
    // xhttp.open("GET", URL, false);
    //   xhttp.send();
      
  }

  postXML(URL: string, data){
    var xhttp = new XMLHttpRequest();
    console.log(data);
    xhttp.onreadystatechange = function(response){
      if(this.status==200){
        var statusString = 'User account created successfully'
        return statusString;
      }
      else{
        console.log(xhttp.responseText);
      }
    }
    //var data1 = JSON.stringify(data);
    xhttp.open("POST", URL, true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(data));
  //   var cache = [];
  //   xhttp.send(JSON.stringify(data, function(key, value) {
  //     if (typeof value === 'object' && value !== null) {
  //         if (cache.indexOf(value) !== -1) {
  //             // Duplicate reference found, discard key
  //             return;
  //         }
  //         // Store value in our collection
  //         cache.push(value);
  //     }
  //     return value;
  // }));
  }
}

export interface logins{
  id: number;
  username: string;
  pass: string;
  firstname: string;
  lastname: string;
  accounttype: number;
}

