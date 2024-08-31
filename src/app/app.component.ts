import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Instgram';



  username: string = '';
  imagePath: string = '';
  description: string = '';

  constructor(private router: Router) {}

  ngOnInit(): void {
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras?.state) {
      this.username = navigation.extras.state['username'];
      this.imagePath = navigation.extras.state['imagePath'];
      this.description = navigation.extras.state['description'];
    }
  }
}
