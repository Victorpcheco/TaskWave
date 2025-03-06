import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/register/auth.service';
import { Component, ViewChild} from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NotificationComponent } from './notification/notification.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
  providers: [AuthService],
  standalone: true, 
  imports: [ReactiveFormsModule, CommonModule, HttpClientModule, NotificationComponent]
})
export class RegisterComponent {

  registroForm: FormGroup; 
  @ViewChild(NotificationComponent) notification!: NotificationComponent;

  // O construtor recebe o FormBuilder como injeção de dependência
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private httpClient: HttpClient
  ) {
   
    this.registroForm = this.fb.group({
      nome: ['', Validators.required], 
      email: ['', [Validators.required, Validators.email]], 
      senha: ['', [Validators.required, Validators.minLength(6)]] 
    });
  }

  // Método chamado ao submeter o formulário
  onSubmit() {
    if (this.registroForm.invalid) {
      this.registroForm.markAllAsTouched(); // Exibe os erros ao usuário antes de enviar
      return;
    }

    // Chama o serviço de registro
    this.authService.register(this.registroForm.value).subscribe({
      next: (response) => {
        console.log('Registro concluído!', response);
        this.notification.message = 'Registro realizado com sucesso!';
        this.notification.type = 'success';
        this.notification.show();
      },
      error: (error) => {
        console.error('Erro no registro', error);
        this.notification.message = 'Não foi possível realizar o registro! Revise os dados.';
        this.notification.type = 'error';
        this.notification.show();
      }
    });
  }

}