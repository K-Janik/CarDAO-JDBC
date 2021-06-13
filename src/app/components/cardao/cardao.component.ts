import { Component, OnInit } from '@angular/core';
import {RootObject} from './car';
import {CardaoService} from '../services/cardao.service';
import {NgForm} from '@angular/forms';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-cardao',
  templateUrl: './cardao.component.html',
  styleUrls: ['./cardao.component.css']
})
export class CardaoComponent implements OnInit {

  public rootObject: RootObject[];
  public deleteCar: RootObject;
  public fromYear: number;
  public untilYear: number;

  constructor(private cardaoService: CardaoService) { }

  ngOnInit(): void {
    this.getCars();
  }

  public getCars(): void {
    this.cardaoService.getCar().subscribe(
      (response: RootObject[]) => {
        this.rootObject = response;
        console.log(this.rootObject);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddCar(addForm: NgForm): void {
    document.getElementById('add-car-form').click();
    this.cardaoService.insertCar(addForm.value).subscribe(
      (response: RootObject) => {
        console.log(response);
        this.getCars();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onSearchCars(value1: number, value2: number): void {
    document.getElementById('search-car-form').click();
    this.fromYear = value1;
    this.untilYear = value2;
    this.cardaoService.searchCarsByYear(value1, value2).subscribe(
      (response: RootObject[]) => {
        console.log(response);
        this.rootObject = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCarById(carId: number): void {
    this.cardaoService.deleteCarById(carId).subscribe(
      (response: void) => {
        console.log(response);
        this.getCars();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(rootObject: RootObject, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addCarModal');
    }
    if (mode === 'delete') {
      this.deleteCar = rootObject;
      button.setAttribute('data-target', '#deleteCarModal');
    }
    if (mode === 'search') {
      button.setAttribute('data-target', '#searchCarModal');
    }
    container.appendChild(button);
    button.click();
  }
}


