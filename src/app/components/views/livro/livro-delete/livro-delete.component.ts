import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-delete',
  templateUrl: './livro-delete.component.html',
  styleUrls: ['./livro-delete.component.css']
})
export class LivroDeleteComponent {
  constructor(private service: LivroService, private route: ActivatedRoute, private router: Router) { }

  categoria_id: String = ''

  livro: Livro = {
    id: '',
    titulo: '',
    autor: '',
    editora: '',
    descricao: ''

  }
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.categoria_id = this.route.snapshot.paramMap.get('categoria_id')!
    this.livro.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  findById(): void {
    this.service.findById(this.livro.id!).subscribe((resposta) => {
      this.livro=resposta
    })
  }

  delete(): void {
    this.service.delete(this.livro.id!).subscribe(() => {
      this.router.navigate([`categorias/${this.categoria_id}/livro`])
      this.service.mensagem("Livro removido com sucesso")
    }, errr => {
      this.service.mensagem("Erro ao remover Livro, por favor tente mais tarde!")
    })
  }

  cancel(): void {
    this.router.navigate([`categorias/${this.categoria_id}/livro`])
  }

}
