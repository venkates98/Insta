import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Instagram } from '../instagram';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent  {
  posts: Instagram[];

  constructor(private rt: Router) {
    const navigation = this.rt.getCurrentNavigation();
    this.posts = navigation?.extras?.state?.['posts'] || [];
  }

  ngOnInit(): void {
    // Now you can use this.posts to display the Instagram posts in the view component
  }gotologin(){
    this.rt.navigate(["login"]);
  }

  
}
