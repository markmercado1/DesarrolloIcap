export class Trabajador {
  constructor(
    public idTrabajador: number,
    public tusername: string,
    public tnombre: string,
    public trol: 'ADMIN' | 'OTRO',
    public tcorreo: string
  ) {}
}