import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CategoriaService } from '../../categoria.service';
import { Categoria } from '../categoria.model';

@Component({
  selector: 'app-categoria-delete',
  templateUrl: './categoria-delete.component.html',
  styleUrls: ['./categoria-delete.component.css']
})
export class CategoriaDeleteComponent {

  categoria: Categoria = {
    id: "",
    titulo: "",
    descricao: ""
  }
  constructor(private service: CategoriaService, private route: ActivatedRoute, private router: Router) { }
  
  ngOnInit(): void {
    this.categoria.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  findById(): void {
    this.service.findById(this.categoria.id!).subscribe(resposta => {
      this.categoria.titulo = resposta.titulo
      this.categoria.descricao = resposta.descricao
      console.log(this.categoria)
    })
  }

  delete():void {
    this.service.delete(this.categoria.id!).subscribe((resposta) =>{
      this.service.mensagem("Categoria removida com sucesso!")
      this.router.navigate(['categorias']) 
    }, err => {
      this.service.mensagem(err.error.error)
    })
  }

  cancel(): void{
    this.router.navigate(['categorias'])
  }
}
