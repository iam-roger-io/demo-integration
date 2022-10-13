import { ConfigurationsService } from './../_services/configurations.service';
import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { BffService } from '../_services/bff.service';


@Component({
  selector: 'app-logged-home',
  templateUrl: './logged-home.component.html',
  styleUrls: ['./logged-home.component.css']
})
export class LoggedHomeComponent implements OnInit {

  listPerfil: any;

  userDetails: any;
  userRoles: string[] | undefined;
  logged: boolean;
  tokenJWT: string | undefined;
  instanceName: string | undefined;
  configurations:any;

  constructor(private keycloakService: KeycloakService,  private bffService: BffService, private configurationsService:ConfigurationsService) {
    this.logged=false;
    this.configurations = this.configurationsService.settings;
  }

  title = 'portal-front-angular';


  async ngOnInit() {

    this.instanceName=this.configurations.instanceName;

    if (await this.keycloakService.isLoggedIn()) {

      this.tokenJWT = await this.keycloakService.getToken();

      this.userDetails = await this.keycloakService.loadUserProfile();
      this.userRoles = await this.keycloakService.getUserRoles();

      this.logged=true;
      console.log(this.userRoles);

      let token = await this.keycloakService.getToken();

      this.bffService.getAllPerfil(token)
      .subscribe(resp => {
        this.listPerfil = resp;
        console.log(this.listPerfil);
      });

    }
  }

}
