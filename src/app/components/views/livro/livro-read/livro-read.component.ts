import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-read',
  templateUrl: './livro-read.component.html',
  styleUrls: ['./livro-read.component.css']
})
export class LivroReadComponent {
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

  cancel(): void {
    this.router.navigate([`categorias/${this.categoria_id}/livro`])
  }
}
