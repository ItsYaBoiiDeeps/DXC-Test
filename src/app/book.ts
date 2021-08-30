import { Author } from "./author";

export class Book {


    bookId!:number;
    bookIsbn!:number;
    bookTitle!:string;
    bookYear!:number;
    bookPrice!:number;
    author!:Author[];

}
