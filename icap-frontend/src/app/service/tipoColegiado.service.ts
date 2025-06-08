import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { BehaviorSubject, Subject } from 'rxjs';
import { TipoColegiado } from '../models/TipoColegiado';

@Injectable({
  providedIn: 'root'
})
export class TipoColegiadoService extends GenericService<TipoColegiado> {

  private entidadSubject = new BehaviorSubject<TipoColegiado[]>([]);
  private messageChange: Subject<string> = new Subject<string>();

  constructor(protected override http: HttpClient) {
    super(http, `${environment.HOST}/tipoColegiado`);
  }

  setEntidadChange(data: TipoColegiado[]) {
    this.entidadSubject.next(data);
  }

  getEntidadChange() {
    return this.entidadSubject.asObservable();
  }

  setMessageChange(data: string) {
    this.messageChange.next(data);
  }

  getMessageChange() {
    return this.messageChange.asObservable();
  }
}
