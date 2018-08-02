package com.example.fredy.inventoryapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Herramienta extends AppCompatActivity {
    Button guardar;
    Spinner spinner, spinner1,spinner2,spinner3,spinner4,spinner5,spinner6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramienta);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

       spinner= findViewById(R.id.spinnerll);
       spinner1=findViewById(R.id.spinnermarti);
       /*spinner2=findViewById(R.id.spinnerd);
       spinner3=findViewById(R.id.spinnerp);
       spinner4=findViewById(R.id.spinnerme);
       spinner5=findViewById(R.id.spinneres);
       spinner6=findViewById(R.id.spinnerta);*/
       guardar=findViewById(R.id.guardarhe);


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
        spinner.setAdapter(arrayAdapter);
        spinner1.setAdapter(arrayAdapter);
        /*spinner2.setAdapter(arrayAdapter);
        spinner3.setAdapter(arrayAdapter);
        spinner4.setAdapter(arrayAdapter);
        spinner5.setAdapter(arrayAdapter);
        spinner6.setAdapter(arrayAdapter);*/
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Herramienta.this,Lista.class);
                int llave = Integer.parseInt(spinner.getSelectedItem().toString());
                int martillo = Integer.parseInt(spinner1.getSelectedItem().toString());
                boolean sw = false;
                intent.putExtra("llav",llave);
                intent.putExtra("mart",martillo);
                intent.putExtra("entro",sw);
                Herramienta.this.startActivity(intent);
            }
        });
    }
}

