package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class View_final extends AppCompatActivity {

    Button salir,enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final);

        enviar=findViewById(R.id.send);
        salir=findViewById(R.id.exit);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent= new Intent(View_final.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"FINALIZÓ", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] to = { "fredyjesus2013@gmail.com", "soymigue15@gmail.com" };
                String[] cc = { "mrojasgarcia22@gmail.com" };
                Send(to, cc, "Hola",
                        "Esto es un email enviado desde una app de Android, PRUEBA No2");
            }
        });

    }

    private void Send (String[] to, String[] cc,String asunto, String mensaje){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }


    }

