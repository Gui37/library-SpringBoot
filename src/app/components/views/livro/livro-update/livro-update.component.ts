import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-update',
  templateUrl: './livro-update.component.html',
  styleUrls: ['./livro-update.component.css']
})
export class LivroUpdateComponent {
  constructor(private service: LivroService, private route: ActivatedRoute, private router: Router) { }


  categoria_id: String = ''

  titulo = new FormControl('', [Validators.minLength(3)])
  autor = new FormControl('', [Validators.minLength(3)])
  editora = new FormControl('', [Validators.minLength(3)])
  descricao = new FormControl('', [Validators.minLength(3)])

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

  update(): void {
    this.service.update(this.livro).subscribe((resposta) => {
      this.router.navigate([`categorias/${this.categoria_id}/livro`])
      this.service.mensagem("Livro actualizado com sucesso")
    }, errr => {
      this.service.mensagem("Erro ao criar Livro, por favor tente mais tarde!")
    })
  }

  cancel(): void {
    this.router.navigate([`categorias/${this.categoria_id}/livro`])
  }
  getMessage() {
    if (this.titulo.invalid) {
      return 'O campo Título deve ter entre 3 a 100 caracteres'
    }
    if (this.autor.invalid) {
      return 'O campo Autor deve ter entre 3 a 100 caracteres'
    }
    if (this.editora.invalid) {
      return 'O campo Editora deve ter entre 3 a 100 caracteres'
    }
    if (this.descricao.invalid) {
      return 'O campo Descrição deve ter entre 3 a 20.000 caracteres'
    }
    return false;
  }
}
