import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../author.service';
import { Book } from '../book';

@Component({
  selector: 'app-addauthors',
  templateUrl: './addauthors.component.html',
  styleUrls: ['./addauthors.component.css']
})
export class AddauthorsComponent implements OnInit {

  author:Author=new Author();
  id!:number;
  book:Book=new Book();
  
  constructor(private authorService:AuthorService,private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
  }

  onSubmit(){
    this.book.bookId=this.id;
    this.author.book=this.book;
    this.createAuthor();
  }

  createAuthor(){
    this.authorService.createAuthor(this.author).subscribe(data=>
      {
        console.log(data);
        this.redirectToMain();
      },
      error=>console.log(error));
  }

  redirectToMain(){
    this.router.navigate(['/']);
  }

}
