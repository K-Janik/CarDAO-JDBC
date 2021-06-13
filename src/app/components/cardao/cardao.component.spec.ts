import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardaoComponent } from './cardao.component';

describe('CardaoComponent', () => {
  let component: CardaoComponent;
  let fixture: ComponentFixture<CardaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardaoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
