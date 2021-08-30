import { Component, OnInit, ɵSWITCH_TEMPLATE_REF_FACTORY__POST_R3__ } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Author } from '../author';
import { Book } from '../book';
import { BookService } from '../book.service';


@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent implements OnInit {

  book:Book=new Book();


  constructor(private bookService:BookService,private router:Router) { }

  ngOnInit(): void {

  }

  onSubmit(){
    this.saveBook();
 
  }

  saveBook(){
    this.bookService.createBook(this.book).subscribe(data=>
      {
        console.log(data);
        this.redirectBookList();
      },error=>
      alert("Duplicate ISBN"));
  }

  redirectBookList(){
    this.router.navigate(['/']);
   
  }

  
}
