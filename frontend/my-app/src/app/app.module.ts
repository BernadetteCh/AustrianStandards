import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { ShopComponent } from './shop/shop.component';
import { HeaderComponent } from './header/header.component';
import { ProductCardComponent } from './product-card/product-card.component';
import { WarenkorbComponent } from './warenkorb/warenkorb.component';
import { WarenkorbCardComponent } from './warenkorb-card/warenkorb-card.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    RegisterComponent,
    LoginComponent,
    ShopComponent,
    HeaderComponent,
    ProductCardComponent,
    WarenkorbComponent,
    WarenkorbCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
