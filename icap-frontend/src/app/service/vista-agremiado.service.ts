import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { VistaAgremiado } from '../models/VistaAgremiado';
import { GenericService } from './generic.service';
import { environment } from '../../environments/environment.development';
import { AgremiadoPage } from '../models/AgremiadoPage';

@Injectable({
  providedIn: 'root',
})
export class VistaAgremiadoService extends GenericService<VistaAgremiado> {
  //  private url = 'http://localhost:6060/api/vista-agremiados';
  private agremiadoSubject: Subject<VistaAgremiado[]> = new Subject<
    VistaAgremiado[]
  >();

  constructor(protected override http: HttpClient) {
    super(http, `${environment.HOST}/api/vista-agremiados`);
  }

  listPageable(page: number, size: number): Observable<AgremiadoPage> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size)
      .set('sortBy', 'idAgremiado');

    return this.http.get<AgremiadoPage>(`${this.url}/agremiados`, { params });
  }
  list(): Observable<VistaAgremiado> {
    return this.http.get<VistaAgremiado>(this.url); // ← asegúrate que `this.url` sea correcto
  }

  getAgremiadosSubject() {
    return this.agremiadoSubject.asObservable();
  }

  setAgremiadosSubject(data: VistaAgremiado[]) {
    this.agremiadoSubject.next(data);
  }
  buscarPorId(id: number): Observable<VistaAgremiado> {
    return this.http.get<VistaAgremiado>(`${this.url}/buscar?id=${id}`);
  }
  listPageableFiltered(
    filtro: string,
    page: number,
    size: number
  ): Observable<any> {
    return this.http.get<any>(`${this.url}/filtrar`, {
      params: {
        filtro: filtro,
        page: page,
        size: size,
      },
    });
  }
}
