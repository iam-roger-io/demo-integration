import { NgModule, APP_INITIALIZER } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoggedHomeComponent } from './logged-home/logged-home.component';
import { HomeComponent } from './home/home.component';
import { TopBarComponent } from './top-bar/top-bar.component';

import { KeycloakService } from 'keycloak-angular';
import { ConfigurationsService } from './_services/configurations.service';
import { initializer } from './_utils/app-init';
import { HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    LoggedHomeComponent,
    HomeComponent,
    TopBarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      multi: true,
      deps: [KeycloakService, ConfigurationsService]
    },
    KeycloakService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

  configurations:any;

  constructor(private configurationsService:ConfigurationsService) { 
    this.configurations = this.configurationsService.settings;
  }

 }
