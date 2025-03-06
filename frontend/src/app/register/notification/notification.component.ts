import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.scss',
  standalone: true,
  imports: [CommonModule]
})
export class NotificationComponent {
  @Input() message: string = ''; // Mensagem a ser exibida
  @Input() type: 'success' | 'error' = 'success'; // Define o tipo de notificação
  isVisible: boolean = false; // Controle de visibilidade da notificação

  show() {
    this.isVisible = true;
    setTimeout(() => this.isVisible = false, 3000); // Oculta após 3 segundos
  }
}
