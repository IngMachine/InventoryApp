package com.example.fredy.inventoryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {
    TextView tvNombre,tvUsuario,tvEdad,tvPassword,tvEmail;
    Button btn;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_usuario);
        tvNombre = findViewById(R.id.TextV_nombre);
        tvUsuario = findViewById(R.id.TextV_usuario);
        tvEdad = findViewById(R.id.TextV_edad);
        tvPassword = findViewById(R.id.TextV_password);
        tvEmail = findViewById(R.id.TextV_email);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age",-1);
        String password = intent.getStringExtra("password");
        String email = intent.getStringExtra("email");

        tvNombre.setText(name);
        tvUsuario.setText(username);
        tvPassword.setText(password);
        tvEdad.setText(age+"");
        tvEmail.setText(email);

        btn = findViewById(R.id.buttoningre);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn = new Intent(Usuario.this, Lista.class);
                startActivity(btn);
            }
        });



    }
}
