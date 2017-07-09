import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-order-switcher',
  templateUrl: './order-switcher.component.html',
  styleUrls: ['./order-switcher.component.scss']
})
export class OrderSwitcherComponent implements OnInit {

  @Input() disabled : boolean;
  constructor() { }

  ngOnInit() {
  }

}
