import { Pago } from "./Pago";


export class DetallePago {
  constructor(
    public idDetallePago: number,
    public dpConcepto: string,
    public dpMonto: number,
    public dpPeriodo: string,
    public pago: number
  ) {}
}
export class DetallePagoReport {
  constructor(
    public idDetallePago: number,
    public dpConcepto: string,
    public dpMonto: number,
    public dpPeriodo: string,
    public pago: Pago
  ) {}
}
