import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Livro } from "./livro.model";

@Injectable({
  providedIn: 'root'
})
export class LivroService {
  baseUrl = environment.baseUrl
  constructor(private http: HttpClient) { }

  findAllByCategoria(categoria_id: String): Observable<Livro[]>{
    const url = `${this.baseUrl}/livro?categoria=${categoria_id}`
    return this.http.get<Livro[]>(url)
  }
}
