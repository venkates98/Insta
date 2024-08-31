import { Component, OnInit } from '@angular/core';
import { InstagramService } from '../instagram.service';
import { Router } from '@angular/router';
import { Instagram } from '../instagram';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  username: string;
  password: string;

  posts: Instagram[];

  constructor(private rt: Router, private instagramService: InstagramService) { }

  ngOnInit(): void {
    this.validateUser();
  }

  validateUser(): void {
    this.instagramService.login(this.username, this.password).subscribe(
      (data: Instagram[]) => {
        this.posts = data;
        this.rt.navigate(['view'], { state: { posts: this.posts } });
      },
      error => {
        console.error('Login failed', error);
        // Handle error (e.g., show an error message)
      }
    );
  }
}
