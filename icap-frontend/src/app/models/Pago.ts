import { Agremiado } from "./Agremiado";

export class Pago {
  constructor(
    public idPago: number,
    public agremiado: number,
    public pmedioPago: string,
    public pfechaPago: string,
    public pmonto: number
  ) {}
}

export class PagoReport {
  constructor(
    public idPago: number,
    public agremiado: Agremiado,
    public pmedioPago: string,
    public pfechaPago: string,
    public pmonto: number
  ) {}
}