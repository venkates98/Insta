import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map, Observable, tap } from 'rxjs';
import { Instagram } from './instagram';

@Injectable({
  providedIn: 'root'
})
export class InstagramService {
  private baseUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<Instagram[]> {
    return this.http.get<Instagram[]>(`${this.baseUrl}/signin/${username}/${password}`).pipe(
      map(response => response.map(instagram => 
        new Instagram(instagram.id, instagram.imagePath, instagram.description, instagram.userId)
      ))
    );
  }
}
