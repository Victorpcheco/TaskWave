import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private notificationSubject = new BehaviorSubject<{message: string, type: 'sucess' | 'error'} | null>(null);
  notification$ = this.notificationSubject.asObservable();

  showSucess(message: string) {
    this.notificationSubject.next({message, type: 'sucess'});
  }
  showError(message: string) {
    this.notificationSubject.next({message, type: 'error'});
  }

  clearNotification() {
    this.notificationSubject.next(null)
  }


  constructor() { }
}
