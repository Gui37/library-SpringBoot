import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-read-all',
  templateUrl: './livro-read-all.component.html',
  styleUrls: ['./livro-read-all.component.css']
})
export class LivroReadAllComponent {
 displayedColumns: string[] = ['id', 'titulo','livros', 'accoes'];

 categoria_id:String =''

 livro:Livro[] = []

  constructor(private service: LivroService ,private router: Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.categoria_id = this.route.snapshot.paramMap.get('categoria_id')!
    this.findAllByCategoria()
  }
  findAllByCategoria():void{
    this.service.findAllByCategoria(this.categoria_id).subscribe((resposta =>{
      this.livro=resposta;
      console.log(this.livro)
    }))
  }
}
