import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ShopComponent } from './shop/shop.component';
import { WarenkorbComponent } from './warenkorb/warenkorb.component';

const routes: Routes = [
  {
    path:"",
    component:RegisterComponent
  },
  {
    path:"login",
    component:LoginComponent
  }, 
  {
    path:"shop",
    component:ShopComponent
  },
  {
    path:"warenkorb",
    component:WarenkorbComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
