import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import {Router} from "@angular/router"


@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  userDetails: any;
  userRoles: string[] | undefined;
  logged: boolean;

  constructor(private keycloakService: KeycloakService, private router: Router) {
    this.logged = false;
  }

  async ngOnInit() {

    if (await this.keycloakService.isLoggedIn()) {
      this.userDetails = await this.keycloakService.loadUserProfile();
      this.userRoles = await this.keycloakService.getUserRoles();
      this.logged = true;
    }
  }

  doLogout() {
    this.logged = false;
    this.router.navigate(['']).then(data1=>{

      this.keycloakService.logout().then(data => {
        
      })
      .catch(err => {
        console.log(err);
      });

    }).catch(err1 => {
      console.log(err1);
    });

  }


}
