import { Routes } from '@angular/router';
import { LayoutComponent } from './pages/layout/layout.component';

export const routes: Routes = [
{ path: '', redirectTo:'main' , pathMatch: 'full' },
  { path: 'main', component: LayoutComponent, },
  { path: 'pages',
    component: LayoutComponent,
    loadChildren:()=>import('./pages/pages.routes').then(x=>x.pagesRoutes)
  },

];
