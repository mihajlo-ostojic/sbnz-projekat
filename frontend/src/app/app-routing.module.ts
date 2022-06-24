import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { BookinfoComponent } from './bookinfo/bookinfo.component';
import { ProfileComponent } from './profile/profile.component';
import { UserordersComponent } from './userorders/userorders.component';
import { RecomendationpageComponent } from './recomendationpage/recomendationpage.component';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'home', component: HomeComponent},
  {path:'bookData', component: BookinfoComponent},
  {path:'profile', component: ProfileComponent},
  {path:'orders', component: UserordersComponent},
  {path:'recomendations', component: RecomendationpageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
