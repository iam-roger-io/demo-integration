import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoggedHomeComponent } from './logged-home/logged-home.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './_guards';

const appRoutes: Routes = [
  {
    path: '',
    component: HomeComponent,
    //canActivate: [AuthGuard],
    //data: { roles: ['SuperUser', 'NormalUser'] }
  },
  {
    path: 'logged-home',
    component: LoggedHomeComponent,
    canActivate: [AuthGuard],
    //data: { roles: ['SuperUser', 'NormalUser'] }
  }
]

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
