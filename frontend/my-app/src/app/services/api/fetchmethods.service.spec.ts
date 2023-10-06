import { TestBed } from '@angular/core/testing';

import { FetchmethodsService } from './fetchmethods.service';

describe('FetchmethodsService', () => {
  let service: FetchmethodsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FetchmethodsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
