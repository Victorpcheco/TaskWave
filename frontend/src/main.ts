import { bootstrapApplication } from '@angular/platform-browser';
import { RegisterComponent } from './app/register/register.component';
import { provideHttpClient, withFetch } from '@angular/common/http';  // ✅ Forma correta

bootstrapApplication(RegisterComponent, {
  providers: [provideHttpClient(withFetch())] // ✅ Agora o HttpClient está disponível globalmente
});
