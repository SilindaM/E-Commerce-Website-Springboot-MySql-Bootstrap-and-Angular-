import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpgradeProductComponent } from './upgrade-product.component';

describe('UpgradeProductComponent', () => {
  let component: UpgradeProductComponent;
  let fixture: ComponentFixture<UpgradeProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpgradeProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpgradeProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
