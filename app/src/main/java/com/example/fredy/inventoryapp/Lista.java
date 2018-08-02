package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Lista extends AppCompatActivity {
    TextView tvDatos;


    Button pedir;
    Button enviar;
    boolean swHerramienta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        pedir= findViewById(R.id.pedir);
        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Lista.this, Dotacion.class);
                startActivity(intent);
            }
        });
        /*Intent intent = getIntent();

        final int martillo = intent.getIntExtra("mart",0);
        final int llave = intent.getIntExtra("llav",0);
        final int camisa = intent.getIntExtra("camis",0);
        tvDatos = findViewById(R.id.tvprueba);
        tvDatos.setText(String.format("%s%s%s",llave,martillo,camisa));

        enviar = findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                final int martillo = intent.getIntExtra("mart",0);
                final int llave = intent.getIntExtra("llav",0);
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean sucess = jsonObject.getBoolean("succes");
                                System.out.println(jsonObject);
                                if(sucess){
                                    Intent intent = new Intent(Lista.this,View_final.class);
                                    Lista.this.startActivity(intent);
                                }
                                else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Lista.this);
                                    builder.setMessage("error registro")
                                            .setNegativeButton("Retry",null)
                                            .create().show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                HerramientaRequest herramientaRequest = new HerramientaRequest(llave,martillo,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Lista.this);
                queue.add(herramientaRequest);
            }
        });*/



    }

}