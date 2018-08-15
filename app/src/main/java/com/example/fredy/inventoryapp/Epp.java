package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class
Epp extends AppCompatActivity {

    Spinner spiner, spiner1,spiner2,spiner3,spiner4,spiner5,spiner6,spiner7,spiner8,spiner9;
    ImageButton sig2, ant2;
    TextView tvDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ELEMENTOS PROTECCIÓN PERSONAL");
        Intent intent = getIntent();

        final int camisa = intent.getIntExtra("cami",0);
        final int pantalon = intent.getIntExtra("pant",0);
        final int zapato = intent.getIntExtra("zap",0);
        tvDatos = findViewById(R.id.tvprueba);
        tvDatos.setText(String.format("%s%s%s",camisa,pantalon,zapato));


        spiner= findViewById(R.id.spinnerc);
        spiner1=findViewById(R.id.spinnergua);
        spiner2=findViewById(R.id.spinnerg);
        spiner3=findViewById(R.id.spinnerb);
        spiner4=findViewById(R.id.spinnera);
        spiner5=findViewById(R.id.spinnertapa);
        spiner6=findViewById(R.id.spinnerar);
        spiner7=findViewById(R.id.spinnerpants);
        spiner8=findViewById(R.id.spinnerbar);
        spiner9=findViewById(R.id.spinnertermo);


        sig2 = findViewById(R.id.sig2);
        ant2 = findViewById(R.id.ant2);


        List list = new ArrayList();

        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spiner.setAdapter(arrayAdapter);
        spiner1.setAdapter(arrayAdapter);
        spiner2.setAdapter(arrayAdapter);
        spiner3.setAdapter(arrayAdapter);
        spiner4.setAdapter(arrayAdapter);
        spiner5.setAdapter(arrayAdapter);
        spiner6.setAdapter(arrayAdapter);
        spiner7.setAdapter(arrayAdapter);
        spiner8.setAdapter(arrayAdapter);
        spiner9.setAdapter(arrayAdapter);




        sig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Epp.this,Herramienta.class);
                int casco = Integer.parseInt(spiner.getSelectedItem().toString());
                int gafa = Integer.parseInt(spiner1.getSelectedItem().toString());
                intent.putExtra("casc", casco);
                intent.putExtra("gaf", gafa);
                intent.putExtra("camis", camisa);
                intent.putExtra("panta", pantalon);
                intent.putExtra("zapa", zapato);
                Epp.this.startActivity(intent);
            }
        });

        ant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Epp.this,Dotacion.class);
                int camisa = Integer.parseInt(spiner.getSelectedItem().toString());
                intent.putExtra("camis", camisa);
                Epp.this.startActivity(intent);
            }
        });
    }
    }
