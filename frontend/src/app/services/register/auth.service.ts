import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

  @Injectable({
    providedIn: 'root'
})


  export class AuthService {
    private apiUrl ='http://localhost:8080/usuarios/register';

  constructor(private http: HttpClient) {}

  register(usuario: any): Observable<any> {
    return this.http.post(this.apiUrl, usuario);
  }
}
