import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MaterialModule } from '../../material/material.module';
import { AgremiadoService } from '../../service/agremiado.service';
import { AgremiadoReport } from '../../models/Agremiado';
import { NgIf } from '@angular/common';
import { VistaAgremiado } from '../../models/VistaAgremiado';
import { VistaAgremiadoService } from '../../service/vista-agremiado.service';

@Component({
  selector: 'app-main-agremiado',
  standalone: true,
  templateUrl: './agremiado-main.html',
  styleUrls: ['./agremiado-main.css'],
  imports: [MaterialModule, NgIf],
})
export class MainAgremiadoComponent implements OnInit {
  currentPage = 0;
  pageSize = 20;
  totalRegistros = 0;
  filtro: string = '';

  columnsDefinitions = [
    { def: 'idAgremiado', label: 'ID', hide: false },
    { def: 'dni', label: 'DNI', hide: false },
    { def: 'anombres', label: 'Nombres', hide: false },
    { def: 'aapellidoPaterno', label: 'Apellido Paterno', hide: false },
    { def: 'aapellidoMaterno', label: 'Apellido Materno', hide: false },
    { def: 'adomiciloReal', label: 'Domicilio Real', hide: false },
    { def: 'acelular', label: 'Celular', hide: false },
    { def: 'acorreo', label: 'Correo', hide: false },
    { def: 'alugarNacimiento', label: 'Lugar de Nacimiento', hide: false },
    { def: 'tipoDeColegiado', label: 'Tipo de Colegiado', hide: false },
    { def: 'estadoDeColegiado', label: 'Estado de Colegiado', hide: false },
    { def: 'ultimoPago', label: 'Último Pago', hide: false },
  ];

  dataSource = new MatTableDataSource<VistaAgremiado>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private agremiadoService: VistaAgremiadoService) {}

  ngOnInit(): void {
    this.cargarAgremiados();
  }

 applyFilter(event: any) {
  const filterValue = event?.target?.value?.trim();

  if (!filterValue) {
    this.filtro = '';
    this.cargarAgremiados(); // recarga la lista paginada normal
    return;
  }

  const id = parseInt(filterValue, 10);

  if (!isNaN(id)) {
    // Búsqueda por ID exacto
    this.agremiadoService.buscarPorId(id).subscribe({
      next: (data) => {
        this.dataSource.data = [data]; // muestra solo un resultado
        this.totalRegistros = 1;
      },
      error: () => {
        console.error('No encontrado por ID');
        this.dataSource.data = [];
        this.totalRegistros = 0;
      },
    });
  } else {
    // Búsqueda global por texto (nombre, DNI, apellidos)
    this.filtro = filterValue;
    this.currentPage = 0; // reiniciar página al filtrar
    this.cargarAgremiados(); // este método usará el filtro si está definido
  }
}

 cargarAgremiados() {
  if (this.filtro && this.filtro.trim() !== '') {
    // Si hay texto para filtrar, busca con filtro
    this.agremiadoService.listPageableFiltered(this.filtro.trim(), this.currentPage, this.pageSize)
      .subscribe(data => {
        this.dataSource.data = data.content;
        this.totalRegistros = data.totalElements;
      });
  } else {
    // Si no hay filtro, busca normalmente
    this.agremiadoService.listPageable(this.currentPage, this.pageSize)
      .subscribe(data => {
        this.dataSource.data = data.content;
        this.totalRegistros = data.totalElements;
      });
  }
}
  onPaginateChange(event: any) {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.cargarAgremiados();
  }

  getDisplayedColumns() {
    return this.columnsDefinitions.filter((cd) => !cd.hide).map((cd) => cd.def);
  }

  delete(id: number) {
    // Implementar lógica si decides habilitar eliminación
  }
}
