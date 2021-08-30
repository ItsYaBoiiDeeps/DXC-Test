import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {
  transform(searchables: string[], searchInput: string): any[]{     
      if(!searchInput) {
          return  [];
      }
     searchInput = searchInput.toLowerCase();
     return searchables.filter(
         x =>x.toLowerCase().includes(searchInput)
     )
   }
}