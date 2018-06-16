package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {
    TextView tvNombre,tvUsuario,tvEdad,tvPassword,tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }
}
