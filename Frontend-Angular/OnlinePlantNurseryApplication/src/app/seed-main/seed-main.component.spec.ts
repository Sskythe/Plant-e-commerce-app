import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeedMainComponent } from './seed-main.component';

describe('SeedMainComponent', () => {
  let component: SeedMainComponent;
  let fixture: ComponentFixture<SeedMainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeedMainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeedMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
