import {Component, inject, OnInit} from '@angular/core';
import {MaterialModule} from "../../material/material.module";
import {RouterLink, RouterLinkActive, RouterOutlet} from "@angular/router";
import { Acceso } from '../../models/Acceso';
import { AuthService } from '../../service/auth.service';
import { AccesoService } from '../../service/acceso.service';
//import {ThemeService} from '../../service/theme.service';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [MaterialModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})

export class LayoutComponent implements OnInit{
  //themeService=inject(ThemeService);
  accesos!: Acceso[];
  constructor(
  private authService: AuthService,
 private accesoService: AccesoService,
  ){}

  logout(){
  this.authService.logout();
  }

 ngOnInit(): void {
 this.accesoService.getAccesosChange().subscribe(data => this.accesos = data);
 }

}
