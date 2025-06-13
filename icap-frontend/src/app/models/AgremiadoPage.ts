import { VistaAgremiado } from './VistaAgremiado';

export interface AgremiadoPage {
  content: VistaAgremiado[];
  totalElements: number;
  totalPages: number;
  number: number;
}