import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from "../../environments/environment.development";
import { Agremiado } from "../models/Agremiado";
import { AgremiadoReport } from "../models/Agremiado";
import { BehaviorSubject, Observable, Subject } from "rxjs";
import { GenericService } from './generic.service';

@Injectable({
  providedIn: 'root'
})
export class AgremiadoService extends GenericService<Agremiado> {
  
  // Para cuando necesites enviar actualizaciones a otros componentes (tablas, etc.)
  private agremiadoSubject = new BehaviorSubject<AgremiadoReport[]>([]);
  private agremiadoSeleccionadoSubject = new BehaviorSubject<AgremiadoReport | null>(null);

  // Observables públicos
  agremiadoSeleccionado$ = this.agremiadoSeleccionadoSubject.asObservable();

  constructor(protected override http: HttpClient) {
    super(http, `${environment.HOST}/api/vista-agremiados`);
  }

  // Cargar todos los Agremiados enriquecidos (tipo Report)
  findAllReport(): void {
    this.http.get<AgremiadoReport[]>(this.url).subscribe(data => {
      this.agremiadoSubject.next(data);
    });
  }

  // Buscar por ID y devolver datos enriquecidos (ideal para detalles o editar)
  findByIdReport(id: number): Observable<AgremiadoReport> {
    return this.http.get<AgremiadoReport>(`${this.url}/${id}`);
  }

  // Setear y obtener la lista de agremiados
  setAgremiadoSubject(data: AgremiadoReport[]): void {
    this.agremiadoSubject.next(data);
  }

  getAgremiadoSubject(): Observable<AgremiadoReport[]> {
    return this.agremiadoSubject.asObservable();
  }

  // Seleccionar un agremiado desde un componente
  seleccionarAgremiado(data: AgremiadoReport): void {
    this.agremiadoSeleccionadoSubject.next(data);
  }

  // Listar con paginación si tu backend lo soporta
  listPageable(page: number, size: number): Observable<any> {
    return this.http.get<any>(`${this.url}/pageable?page=${page}&size=${size}`);
  }
}
