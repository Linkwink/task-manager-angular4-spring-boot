import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {
  MdButtonModule, MdCardModule, MdCheckboxModule, MdDialogModule, MdIconModule, MdInputModule, MdListModule,
  MdSnackBarModule,
  MdToolbarModule
} from '@angular/material';
import {AppComponent} from './shared/components/app/app.component';
import {TaskComponent} from './shared/components/task/task.component';
import {ProjectComponent} from './shared/components/project/project.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import 'hammerjs';
import {ProjectHeaderComponent} from './shared/components/project/shared/project-header/project-header.component';
import {ProjectTaskListComponent} from './shared/components/project/shared/project-task-list/project-task-list.component';
import {ProjectTaskGeneratorComponent} from './shared/components/project/shared/project-task-generator/project-task-generator.component';
import {AppToolbarComponent} from './shared/components/app/shared/app-toolbar/app-toolbar.component';
import {ProjectNewModalComponent} from './shared/components/project/shared/project-new-modal/project-new-modal.component';
import {OrderSwitcherComponent} from './shared/components/task/shared/order-switcher/order-switcher.component';
import {HttpModule} from '@angular/http'
import {StompConfig, StompService} from '@stomp/ng2-stompjs';
import {Stomp} from './config/stomp.config'
import {FormsModule} from '@angular/forms'
import {Md2Module} from 'md2'
import { OrderByPipe } from './pipes/order-by/order-by.pipe';
import {TimeToDeadlinePipe} from "./pipes/time-to-deadline/time-to-deadline.pipe";

@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    ProjectComponent,
    ProjectHeaderComponent,
    ProjectTaskListComponent,
    ProjectTaskGeneratorComponent,
    AppToolbarComponent,
    ProjectNewModalComponent,
    OrderSwitcherComponent,
    OrderByPipe,
    TimeToDeadlinePipe,

  ],
  imports: [
    BrowserModule,
    HttpModule,
    MdCardModule,
    MdButtonModule,
    MdIconModule,
    MdCheckboxModule,
    MdDialogModule,
    MdListModule,
    MdInputModule,
    MdToolbarModule,
    MdSnackBarModule,
    Md2Module,
    FormsModule,
    BrowserAnimationsModule,

  ],
  entryComponents: [ProjectNewModalComponent],
  providers: [
    StompService,
    {
      provide: StompConfig,
      useValue: Stomp.config
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
