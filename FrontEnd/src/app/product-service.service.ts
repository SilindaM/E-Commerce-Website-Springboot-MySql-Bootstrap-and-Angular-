import { Injectable } from '@angular/core';
import {  HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Products } from './Models/products';
@Injectable({
  providedIn: 'root'
})

export class ProductServiceService {

   baseUrl="http://localhost:8081/api/products/";
  constructor(private http:HttpClient) { }

  //get Product by id
  public getProductById(id:number):Observable<Products>{
    return this.http.get<Products>(`${this.baseUrl}/${id}`);
  }
  //get all products
  public getAllProducts():Observable<Products>{
    return this.http.get<Products>(this.baseUrl);
  }
  //delete product by id
  public deleteById():Observable<Products>{
    return this.http.delete<Products>(`${this.baseUrl}/${this.baseUrl}`);
  }
  //update product by id
  public updateProduct(id:number,product:Products):Observable<Products>{
      return this.http.put<Products>(`${this.baseUrl}/${id}`,product);
  }
}
