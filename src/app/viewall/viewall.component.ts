import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../author.service';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-viewall',
  templateUrl: './viewall.component.html',
  styleUrls: ['./viewall.component.css']
})
export class ViewallComponent implements OnInit {

id!:number;
book!:Book;
author!:Author[];

  constructor(private route:ActivatedRoute, private bookService:BookService, private authorService:AuthorService) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.bookService.getBookById(this.id).subscribe(data=>{
      this.book=data;
    });

    // for(let temp of this.book.author){
    //   this.author.push(temp);
    // }

  // for(var i=0;i<this.book.author.length;
  }

}
