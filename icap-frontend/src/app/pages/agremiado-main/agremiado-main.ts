import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MaterialModule } from '../../material/material.module';
import { AgremiadoService } from '../../service/agremiado.service';
import { AgremiadoReport } from '../../models/Agremiado';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-main-agremiado',
  standalone: true,
  templateUrl: './agremiado-main.html',
  styleUrls: ['./agremiado-main.css'],
  imports: [MaterialModule,  NgIf]
})
export class MainAgremiadoComponent implements OnInit {

  columnsDefinitions = [
    { def: 'idAgremiado', label: 'ID', hide: true },
    { def: 'dni', label: 'DNI', hide: false },
    { def: 'aNombres', label: 'Nombres', hide: false },
    { def: 'aApellidoPaterno', label: 'Apellido Paterno', hide: false },
    { def: 'aApellidoMaterno', label: 'Apellido Materno', hide: false },
    { def: 'aDomiciloReal', label: 'Domicilio Real', hide: true },
    { def: 'aCelular', label: 'Celular', hide: false },
    { def: 'aCorreo', label: 'Correo', hide: false },
    { def: 'aLugarNacimiento', label: 'Lugar de Nacimiento', hide: true },
    { def: 'aFechaIncorporacion', label: 'Fecha de Incorporación', hide: true },
    { def: 'genero', label: 'Género', hide: false },
    { def: 'aFechaNacimiento', label: 'Fecha de Nacimiento', hide: true },
    { def: 'aDomiciloProcesal', label: 'Domicilio Procesal', hide: true },
    { def: 'aCiudad', label: 'Ciudad', hide: false },
    { def: 'aHabilHasta', label: 'Hábil Hasta', hide: true },
    { def: 'tipoColegiado', label: 'Tipo de Colegiado', hide: false },
    { def: 'estadoColegiado', label: 'Estado de Colegiado', hide: false },
    { def: 'trabajador', label: 'Trabajador Responsable', hide: true },
    { def: 'accion', label: 'Acción', hide: false }
  ];

  dataSource = new MatTableDataSource<AgremiadoReport>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private agremiadoService: AgremiadoService) {}

  ngOnInit(): void {
    this.agremiadoService.getAgremiadoSubject().subscribe(data => {
      this.dataSource.data = data;
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });

    // Llama al método para cargar los datos
    this.agremiadoService.findAllReport();
  }

applyFilter(event: any) {
  const filterValue = event?.target?.value || '';
  this.dataSource.filter = filterValue.trim().toLowerCase();
}

  getDisplayedColumns() {
    return this.columnsDefinitions.filter(cd => !cd.hide).map(cd => cd.def);
  }

  delete(id: number) {
    // Implementar lógica si decides habilitar eliminación
  }
  
}
