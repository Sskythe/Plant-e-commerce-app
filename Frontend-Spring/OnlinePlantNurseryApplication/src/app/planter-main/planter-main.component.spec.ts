import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanterMainComponent } from './planter-main.component';

describe('PlanterMainComponent', () => {
  let component: PlanterMainComponent;
  let fixture: ComponentFixture<PlanterMainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlanterMainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanterMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
