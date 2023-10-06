import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarenkorbCardComponent } from './warenkorb-card.component';

describe('WarenkorbCardComponent', () => {
  let component: WarenkorbCardComponent;
  let fixture: ComponentFixture<WarenkorbCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WarenkorbCardComponent]
    });
    fixture = TestBed.createComponent(WarenkorbCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
