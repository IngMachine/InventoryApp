package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Lista extends AppCompatActivity {


    ImageButton herram, eppp,dota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        herram= findViewById(R.id.herra);
        herram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Lista.this, Herramienta.class);
                startActivity(intent);
            }
        });


        eppp=findViewById(R.id.epp);
        eppp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Lista.this, Epp.class);
                startActivity(intent);
            }
        });

        dota= findViewById(R.id.dotacion);
        dota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Lista.this, Dotacion.class);
                startActivity(intent);
            }
        });


    }
}