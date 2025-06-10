import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VistaAgremiadoService {
    private url = 'http://localhost:6060/api/vista-agremiados';
  private agremiadosSubject = new BehaviorSubject<any>({});

  constructor(private http: HttpClient) {}

listPageable(page: number, size: number): Observable<any> {
  return this.http.get<any>(`${this.url}`); // sin paginación por ahora
}
list(): Observable<any> {
  return this.http.get<any>(this.url); // ← asegúrate que `this.url` sea correcto
}



  getAgremiadosSubject() {
    return this.agremiadosSubject.asObservable();
  }

  setAgremiadosSubject(data: any) {
    this.agremiadosSubject.next(data);
  }
}
