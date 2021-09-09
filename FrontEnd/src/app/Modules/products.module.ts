import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { UpgradeProductComponent } from './upgrade-product/upgrade-product.component';



@NgModule({
  declarations: [
    ProductListComponent,
    ProductDetailsComponent,
    UpgradeProductComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ProductsModule { }
