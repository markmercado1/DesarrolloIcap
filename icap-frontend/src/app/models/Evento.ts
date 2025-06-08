import { Trabajador } from "./Trabajador";

export class Evento {
  constructor(
    public idEvento: number,
    public trabajador: number,
    public efechaCreacion: string,
    public efechaInicio: string,
    public edocumento: string,
    public edescripcion: string,
    public efechaFin: string,
    public eestado: string,
    public etitulo: string,
    public eimagen: string
  ) {}
}
export class EventoReport {
  constructor(
    public idEvento: number,
    public trabajador: Trabajador, // objeto completo para mostrar nombre, correo, etc.
    public efechaCreacion: string,
    public efechaInicio: string,
    public edocumento: string,
    public edescripcion: string,
    public efechaFin: string,
    public eestado: string,
    public etitulo: string,
    public eimagen: string
  ) {}
}