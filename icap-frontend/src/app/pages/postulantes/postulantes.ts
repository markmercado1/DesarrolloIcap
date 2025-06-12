import { Component } from '@angular/core';
import { MaterialModule } from '../../material/material.module';

@Component({
  selector: 'app-postulantes',
  standalone: true,
  templateUrl: './postulantes.html',
  styleUrls: ['./postulantes.css'],
   imports: [MaterialModule],
})
export class PostulantesComponent {
  postulantes: any[] = [];
  nuevoPostulante: any = {
    nombre: '',
    apellidos: '',
    dni: '',
    telefono: '',
    direccion: '',
    estado: 'Activo',
  };
  postulanteEditando: any = null;

  agregarPostulante() {
    this.postulantes.push({ ...this.nuevoPostulante });
    this.nuevoPostulante = {
      nombre: '',
      apellidos: '',
      dni: '',
      telefono: '',
      direccion: '',
      estado: 'Activo',
    };
  }

  editarPostulante(postulante: any) {
    this.postulanteEditando = { ...postulante };
  }

  guardarCambios() {
    const index = this.postulantes.findIndex(p => p.dni === this.postulanteEditando.dni);
    if (index !== -1) {
      this.postulantes[index] = { ...this.postulanteEditando };
    }
    this.postulanteEditando = null;
  }

  eliminarPostulante(postulante: any) {
    this.postulantes = this.postulantes.filter(p => p !== postulante);
  }
}
