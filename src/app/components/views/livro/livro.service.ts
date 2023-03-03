import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Livro } from "./livro.model";

@Injectable({
  providedIn: 'root'
})
export class LivroService {
  baseUrl = environment.baseUrl
  constructor(private http: HttpClient, private router: Router, private _snack: MatSnackBar) { }

  findAllByCategoria(categoria_id: String): Observable<Livro[]> {
    const url = `${this.baseUrl}/livro?categoria=${categoria_id}`
    return this.http.get<Livro[]>(url)
  }

  create(livro: Livro, categoria_id: String): Observable<Livro> {
    const url = `${this.baseUrl}/livro?categoria=${categoria_id}`
    return this.http.post<Livro>(url, livro)
  }

  mensagem(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000
    })
  }
}