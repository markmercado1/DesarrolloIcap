import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {Usuario} from '../models/Usuario';

interface ICredencialesRequest{
  user: string;
  clave: string;
 }




@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url: string = `${environment.HOST}/users`;
  constructor(
  private http: HttpClient,
  private router: Router
  ) { }
  login(user: string, clave: string){
  const body: ICredencialesRequest = { user, clave};
  return this.http.post<Usuario>(this.url+`/login`, body);
  }
  logout(){
  sessionStorage.clear();
  this.router.navigate(['login']);
  }

  isLogged(){
  return sessionStorage.getItem(environment.TOKEN_NAME) != null;
  }

}