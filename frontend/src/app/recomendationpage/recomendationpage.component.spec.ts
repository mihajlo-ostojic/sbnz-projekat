import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecomendationpageComponent } from './recomendationpage.component';

describe('RecomendationpageComponent', () => {
  let component: RecomendationpageComponent;
  let fixture: ComponentFixture<RecomendationpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecomendationpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecomendationpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
