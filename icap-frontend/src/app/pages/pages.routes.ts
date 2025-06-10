import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainAgremiadoComponent } from './agremiado-main/agremiado-main';
import { EventoEditComponent } from './eventoo-main/eventoo-main';

export const pagesRoutes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'agremiados', component: MainAgremiadoComponent },
  { path: 'evento', component: EventoEditComponent },
];
