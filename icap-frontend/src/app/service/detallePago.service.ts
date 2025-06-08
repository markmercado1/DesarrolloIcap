import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Subject } from 'rxjs';
import { environment } from '../../environments/environment';
import { DetallePago } from '../models/DetallePago';
import { DetallePagoReport } from '../models/DetallePago';

@Injectable({
  providedIn: 'root'
})
export class DetallePagoService extends GenericService<DetallePago> {

  private entidadSubject = new BehaviorSubject<DetallePagoReport[]>([]);
  private messageChange = new Subject<string>();

  constructor(protected override http: HttpClient) {
    super(http, `${environment.HOST}/detallepago`);
  }

  setEntidadChange(data: DetallePagoReport[]) {
    this.entidadSubject.next(data);
  }

  getEntidadChange() {
    return this.entidadSubject.asObservable();
  }

  setMessageChange(message: string) {
    this.messageChange.next(message);
  }

  getMessageChange() {
    return this.messageChange.asObservable();
  }

  // Método para obtener detalles con el objeto Pago completo anidado
  getReporte() {
    return this.http.get<DetallePagoReport[]>(`${this.url}/reporte`);
  }
}
