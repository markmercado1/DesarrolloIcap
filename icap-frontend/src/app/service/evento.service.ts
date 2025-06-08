import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from "../../environments/environment.development";
import { Evento } from "../models/Evento";
import { EventoReport } from "../models/Evento";
import { BehaviorSubject, Observable } from "rxjs";
import { GenericService } from './generic.service';

@Injectable({
  providedIn: 'root'
})
export class EventoService extends GenericService<Evento> {

  // Sujeto para notificar cambios en la lista de eventos
  private eventoSubject = new BehaviorSubject<EventoReport[]>([]);
  private eventoSeleccionadoSubject = new BehaviorSubject<EventoReport | null>(null);

  // Observable para escuchar el evento seleccionado
  eventoSeleccionado$ = this.eventoSeleccionadoSubject.asObservable();

  constructor(protected override http: HttpClient) {
    super(http, `${environment.HOST}/eventos`);
  }

  // Obtener todos los eventos con datos enriquecidos
  findAllReport(): void {
    this.http.get<EventoReport[]>(this.url).subscribe(data => {
      this.eventoSubject.next(data);
    });
  }

  // Obtener un evento específico con datos enriquecidos
  findByIdReport(id: number): Observable<EventoReport> {
    return this.http.get<EventoReport>(`${this.url}/${id}`);
  }

  // Notificar nuevos datos a los componentes suscritos
  setEventoSubject(data: EventoReport[]): void {
    this.eventoSubject.next(data);
  }

  getEventoSubject(): Observable<EventoReport[]> {
    return this.eventoSubject.asObservable();
  }

  // Seleccionar un evento desde la vista
  seleccionarEvento(evento: EventoReport): void {
    this.eventoSeleccionadoSubject.next(evento);
  }

  // Paginación si tu backend lo permite
  listPageable(page: number, size: number): Observable<any> {
    return this.http.get<any>(`${this.url}/pageable?page=${page}&size=${size}`);
  }
}
