import { Component } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  btnSide = true

  changeText(): void {
    if(this.btnSide){ 
      this.btnSide = false; 
    }else{ 
      this.btnSide = true; 
    } 
  }
}
