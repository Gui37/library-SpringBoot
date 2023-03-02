import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoriaService } from '../../categoria.service';
import { Categoria } from '../categoria.model';

@Component({
  selector: 'app-categoria-update',
  templateUrl: './categoria-update.component.html',
  styleUrls: ['./categoria-update.component.css']
})
export class CategoriaUpdateComponent {
  constructor(private service: CategoriaService, private route: ActivatedRoute, private router: Router) { }

  categoria: Categoria = {
    id: "",
    titulo: "",
    descricao: ""
  }
  ngOnInit(): void {
    this.categoria.id = this.route.snapshot.paramMap.get('id')!;
    this.findById();
  }

  update():void {
    this.service.update(this.categoria).subscribe((resposta) =>{
      this.router.navigate(['categorias'])
      this.service.mensagem("Categoria actualizada com sucesso")
    }, err => {
      this.service.mensagem("Verifique se todos os campos estão preenchidos")
    })
  }

  findById(): void {
    this.service.findById(this.categoria.id!).subscribe(resposta => {
      this.categoria.titulo = resposta.titulo
      this.categoria.descricao = resposta.descricao
      console.log(this.categoria)
    })
  }
  cancel(): void {
    this.router.navigate(['categorias'])
  }
}
