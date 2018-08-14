package com.example.fredy.inventoryapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Dotacion extends AppCompatActivity {
    ImageButton sig1;

    Spinner spinnner,spinnner1,spinnner2,spinnner3,spinnner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dotacion);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("DOTACIÓN");


        spinnner= findViewById(R.id.spinnerca);
        spinnner1=findViewById(R.id.spinnerpan);
        spinnner2=findViewById(R.id.cintu);
        spinnner3=findViewById(R.id.chaleco1);
        spinnner4=findViewById(R.id.spinnerimp);


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

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnner.setAdapter(arrayAdapter);
        spinnner1.setAdapter(arrayAdapter);
        spinnner2.setAdapter(arrayAdapter);
        spinnner3.setAdapter(arrayAdapter);
        spinnner4.setAdapter(arrayAdapter);

        sig1 = findViewById(R.id.sig1);
        sig1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Dotacion.this,Epp.class);
                    int camisa = Integer.parseInt(spinnner.getSelectedItem().toString());
                    int pantalon = Integer.parseInt(spinnner1.getSelectedItem().toString());
                    int zapato = Integer.parseInt(spinnner2.getSelectedItem().toString());
                    intent.putExtra("cami",camisa);
                    intent.putExtra("pant",pantalon);
                    intent.putExtra("zap",zapato);
                    Dotacion.this.startActivity(intent);
                           }
        });
        }
}
