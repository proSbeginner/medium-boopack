import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
  ) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      email: [''],
      password: [''],
    });
  }

  onLogin() {
    const e = this.form.controls.email.value.trim();
    const p = this.form.controls.password.value.trim();

    const credentials = {
      username: e,
      password: p,
    };
    const url = `api/login`;

    this.http.post(url, credentials).toPromise().then(user => {
      console.log(user);
    });
  }
}
