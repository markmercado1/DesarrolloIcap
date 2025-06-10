import { Component } from '@angular/core';

@Component({
  selector: 'app-evento-edit',
  standalone: true,
  imports: [ /* CommonModule y FormsModule */ ],
  templateUrl: './eventoo-main.html',
  styleUrls: ['./eventoo-main.css']
})
export class EventoEditComponent {
  evento = {
    titulo: 'Conferencia Legal 2025',
    descripcion: 'Evento académico…',
    fecha: '2025-07-15',
    hora: '09:00',
    ubicacion: 'Auditorio Principal del Colegio',
    archivo: null as File | null
  };

  onFile(event: any) {
    this.evento.archivo = event.target.files[0] ?? null;
  }

  onSubmit() {
    console.log('Enviar al backend:', this.evento);
    // aquí llamarías a tu servicio para hacer PUT /api/eventos/{id}
  }
}
