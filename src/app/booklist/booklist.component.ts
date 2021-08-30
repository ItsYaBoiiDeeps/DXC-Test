import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';


@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {

  books!:Book[];
  bookTitle!:any;

  // public searchInput!:string;
  // public searchables!:string[];

  constructor(private bookService:BookService, private router:Router) { }

  ngOnInit(): void {
    this.getBooks();
  }

 
  private getBooks(){
    this.bookService.getBookList().subscribe(data=>
      {
        this.books=data;
      })
  }

  updateBook(id:number){
    this.router.navigate([`updatebook`,id]);
  }

  deleteBook(id:number){
    this.bookService.deleteBook(id).subscribe(data=>{
      console.log(data);
      this.getBooks();
    })
  }

  createAuthor(id:number){
    this.router.navigate([`addauthor`,id]);
  }

  viewMore(id:number){
    this.router.navigate([`viewall`,id]);
  }


  Search(){
    if(this.bookTitle==""){
      this.ngOnInit();
    }else{
      this.books=this.books.filter(res=>{
        return res.bookTitle.toLocaleLowerCase().match(this.bookTitle.toLocaleLowerCase());
      });
    }
  }
}
