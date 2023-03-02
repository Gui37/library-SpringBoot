import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoriaService } from '../../categoria.service';
import { Categoria } from '../categoria.model';

@Component({
  selector: 'app-categoria-create',
  templateUrl: './categoria-create.component.html',
  styleUrls: ['./categoria-create.component.css']
})
export class CategoriaCreateComponent implements OnInit {

  categoria: Categoria = {
    titulo: '',
    descricao: ''
  }
  constructor(private service: CategoriaService, private router: Router) { }

  ngOnInit(): void {
    this.create();
  }
  
  create(): void {
    this.service.create(this.categoria).subscribe(resposta => {
     this.service.mensagem('Categoria criada com sucesso')
     this.router.navigate(['categorias'])
    },err =>{
      for (let i = 0; i < err.error.errors.length; i++){
        this.service.mensagem(err.error.errors[i].message)
      }
    })
  }

  cancel(): void{
    this.router.navigate(['categorias'])
  }
}
