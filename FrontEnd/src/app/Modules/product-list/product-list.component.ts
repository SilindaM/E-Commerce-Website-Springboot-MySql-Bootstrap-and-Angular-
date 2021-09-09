import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from 'src/app/Models/products';
import { ProductServiceService } from 'src/app/product-service.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private service:ProductServiceService,private router:Router,private active:ActivatedRoute) { }

  products?:any;
  ngOnInit(): void {
    //get all products on load
    this.getAllProducts();
  }
  getAllProducts(){
    this.service.getAllProducts().subscribe(
      data=>{
        this.products=data;
      },
      error=>{
        console.log(error);
      });
  }

}
