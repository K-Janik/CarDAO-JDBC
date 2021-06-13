import { TestBed } from '@angular/core/testing';

import { CardaoService } from './cardao.service';

describe('CardaoService', () => {
  let service: CardaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
