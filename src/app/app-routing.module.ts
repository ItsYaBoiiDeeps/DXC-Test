import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddauthorsComponent } from './addauthors/addauthors.component';
import { BooklistComponent } from './booklist/booklist.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { UpdatebookComponent } from './updatebook/updatebook.component';
import { ViewallComponent } from './viewall/viewall.component';

const routes: Routes = [
  {path:'',redirectTo:'booklist', pathMatch:'full'},
  {path:'booklist',component:BooklistComponent},
  {path:'addbook',component:CreatebookComponent},
  {path:'updatebook/:id',component:UpdatebookComponent},
  {path:'addauthor/:id',component:AddauthorsComponent},
  {path:'viewall/:id',component:ViewallComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
