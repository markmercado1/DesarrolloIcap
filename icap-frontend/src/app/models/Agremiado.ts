import { EstadoColegiado } from "./EstadoColegiado";
import { TipoColegiado } from "./TipoColegiado";
import { Trabajador } from "./Trabajador";

export class Agremiado {
  constructor(
    public idAgremiado: number,
    public dni: string,
    public genero: 'M' | 'F',
    public tipoColegiado: number,
    public estadoColegiado: number,
    public trabajador: number,
    public acelular: string,
    public anombres: string,
    public acorreo: string,
    public aciudad: string,
    public aapellidoMaterno: string,
    public afechaIncorporacion: string, // YYYY-MM-DD
    public aapellidoPaterno: string,
    public afechaNacimiento: string // YYYY-MM-DD
  ) {}
}
export class AgremiadoReport {
  constructor(
    public idAgremiado: number,
    public dni: string,
    public genero: 'M' | 'F',
    public tipoColegiado: TipoColegiado,       // Objeto completo
    public estadoColegiado: EstadoColegiado,   // Objeto completo
    public trabajador: Trabajador,             // Objeto completo
    public acelular: string,
    public anombres: string,
    public acorreo: string,
    public aciudad: string,
    public aapellidoMaterno: string,
    public afechaIncorporacion: string,
    public aapellidoPaterno: string,
    public afechaNacimiento: string
  ) {}
}