import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductoPostComponent } from './producto-post.component';

describe('ProductoPostComponent', () => {
  let component: ProductoPostComponent;
  let fixture: ComponentFixture<ProductoPostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductoPostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductoPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
