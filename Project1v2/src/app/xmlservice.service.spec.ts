import { TestBed } from '@angular/core/testing';

import { XMLServiceService } from './xmlservice.service';

describe('XMLServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: XMLServiceService = TestBed.get(XMLServiceService);
    expect(service).toBeTruthy();
  });
});
