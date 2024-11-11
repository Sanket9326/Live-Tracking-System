import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LiveTrackingComponent } from './live-tracking/live-tracking.component';
import { ChoiceComponent } from './choice/choice.component';

export const routes: Routes = [
    {
        path: '',
        component: LoginComponent,
        pathMatch: 'full'
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'choice',
        component: ChoiceComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'live',
        component: LiveTrackingComponent
    },
    {
        path: '**',
        component: LoginComponent
    }
];
