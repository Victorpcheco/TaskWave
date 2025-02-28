import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';

export const routes: Routes = [
    { path: '', redirectTo: 'register', pathMatch: 'full'}, // rota padrão
    {path: 'register', component: RegisterComponent} // rota alternativa
];
