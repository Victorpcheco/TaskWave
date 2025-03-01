import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/register/auth.service';
import { Component } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
  providers: [AuthService], 
  imports: [ReactiveFormsModule, CommonModule, HttpClientModule] 
})

export class RegisterComponent {
  
  registroForm: FormGroup; // Define um formulário do tipo FormGroup

  // O construtor recebe o FormBuilder como injeção de dependência
  constructor(private fb: FormBuilder, private authService: AuthService, private HttpClient: HttpClient) {
    // Inicializa o formulário usando FormBuilder
    this.registroForm = this.fb.group({
      
      nome: ['', Validators.required], // Campo 'nome' inicializado como string vazia e é obrigatório
      
      
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
  
    this.authService.register(this.registroForm.value).subscribe({
      next: (response) => {
        console.log('Registro concluído!', response);
        // Adicione lógica para redirecionar ou exibir mensagem de sucesso
      },
      error: (error) => {
        console.error('Erro no registro', error);
      }
    });
  }
}
