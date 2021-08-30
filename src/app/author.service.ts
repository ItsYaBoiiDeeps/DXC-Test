import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Author } from './author';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  private baseUrl="http://localhost:8080/author/authors";

  constructor(private httpClient:HttpClient) { }

  getAuthorList():Observable<Author[]>{
    return this.httpClient.get<Author[]>(`${this.baseUrl}`);
  }

  createAuthor(author:Author):Observable<Object>{
   return this.httpClient.post(`${this.baseUrl}`,author);
  }
}
