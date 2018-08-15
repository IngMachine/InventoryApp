package com.example.fredy.inventoryapp;


import android.content.Intent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Herramienta extends AppCompatActivity {
    ImageButton guardar, ant3;
    Spinner spinner, spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,
    spinner11,spinner12,spinner13,spinner14,spinner15,spinner16,spinner17,spinner18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramienta);


        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/
        getSupportActionBar().setTitle("HERRAMIENTAS");

       spinner= findViewById(R.id.spinnermache);
       spinner1=findViewById(R.id.spinnertije);
       spinner2=findViewById(R.id.spinnerlima);
       spinner3=findViewById(R.id.spinnerper);
       spinner4=findViewById(R.id.spinnerexti);
       spinner5=findViewById(R.id.spinnerboti);
       spinner6=findViewById(R.id.spinnercono);
       spinner7=findViewById(R.id.spinneresca);
       spinner8=findViewById(R.id.spinnerali);
       spinner9=findViewById(R.id.spinnermarti);
       spinner10=findViewById(R.id.spinnermulti);
       spinner11=findViewById(R.id.spinnerdest);
       spinner12=findViewById(R.id.spinnercam);
       spinner13=findViewById(R.id.spinnervalla);
       spinner14=findViewById(R.id.spinnercinta);
       spinner15=findViewById(R.id.spinnerkey);
       spinner16=findViewById(R.id.spinnercuchi);
       spinner17=findViewById(R.id.spinnercubo);
       spinner18=findViewById(R.id.spinnerpin);



       guardar=findViewById(R.id.guardar);
       ant3=findViewById(R.id.ant3);


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
        spinner2.setAdapter(arrayAdapter);
        spinner3.setAdapter(arrayAdapter);
        spinner4.setAdapter(arrayAdapter);
        spinner5.setAdapter(arrayAdapter);
        spinner6.setAdapter(arrayAdapter);
        spinner7.setAdapter(arrayAdapter);
        spinner8.setAdapter(arrayAdapter);
        spinner9.setAdapter(arrayAdapter);
        spinner10.setAdapter(arrayAdapter);
        spinner11.setAdapter(arrayAdapter);
        spinner12.setAdapter(arrayAdapter);
        spinner13.setAdapter(arrayAdapter);
        spinner14.setAdapter(arrayAdapter);
        spinner15.setAdapter(arrayAdapter);
        spinner16.setAdapter(arrayAdapter);
        spinner17.setAdapter(arrayAdapter);
        spinner18.setAdapter(arrayAdapter);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                final int llave = Integer.parseInt(spinner.getSelectedItem().toString());
                final int martillo = Integer.parseInt(spinner1.getSelectedItem().toString());
                final int casco = intent.getIntExtra("casc",0);
                final int gafa = intent.getIntExtra("gaf",0);
                final int camisa = intent.getIntExtra("camis",0);
                final int pantalon = intent.getIntExtra("panta",0);
                final int zapato = intent.getIntExtra("zapa",0);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean sucess = jsonObject.getBoolean("succes");
                            System.out.println(jsonObject);
                            if(sucess){
                                Intent intent = new Intent(Herramienta.this,View_final.class);
                                Herramienta.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Herramienta.this);
                                builder.setMessage("error registro")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                HerramientaRequest herramientaRequest = new HerramientaRequest(llave,martillo,responseListener);
                DotacionRequest dotacionRequest = new DotacionRequest(camisa,pantalon,zapato,responseListener);
                EppRequest eppRequest = new EppRequest(casco,gafa,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Herramienta.this);
                queue.add(herramientaRequest);
                queue.add(dotacionRequest);
                queue.add(eppRequest);

            }
        });

        ant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Herramienta.this,Epp.class);
                Herramienta.this.startActivity(intent);
            }
        });


    }
}

