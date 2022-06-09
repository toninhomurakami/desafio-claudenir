import { MovementService } from '../services/movement.service';
import { ProductCosifService } from '../services/product-cosif.service';
import { ProductService } from '../services/product.service';
import { Component, OnInit } from '@angular/core';
import { Movement } from '../model';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-movements',
  templateUrl: './movements.component.html',
  styleUrls: ['./movements.component.css']
})
export class MovementsComponent implements OnInit {

  productsCombo = [];
  productsCosifCombo = [];
  movements = [];

  componentsDisabled = true;

  movement: Movement = new Movement();

  constructor(
    private productService: ProductService,
    private productCosifService: ProductCosifService,
    private movementsService: MovementService
    ) {}

  ngOnInit(): void {
    this.loadProducts();
    this.loadProductsCosif();
    this.loadAllMovements();
  }

  save(form: NgForm) {
    console.log("Movement: "+ JSON.stringify(this.movement));
    this.movementsService.save(this.movement)
      .then( () => {
        this.loadAllMovements();
        this.clearForm(form);
      });
  }

  clearForm(form: NgForm) {
    form.resetForm();
    this.componentsDisabled = true;
  }

  loadProducts() {
    this.productService.findAll()
      .then( response => {
        this.productsCombo = response.map( (p: any) => ({label: p.description, value: p.code}) )
      });
  }

  loadProductsCosif() {
    this.productCosifService.findAll()
      .then( response => {
        this.productsCosifCombo = response.map( (p: any) =>
        ({label: p.id.cosifCode+' - '+p.classification,
            value: p.id.cosifCode
          })
        )
      });
  }

  loadAllMovements() {
    this.movementsService.findAll()
      .then( response => this.movements = response );
  }
}
