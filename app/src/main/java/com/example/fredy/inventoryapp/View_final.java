package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class View_final extends AppCompatActivity {

    ImageButton salir,enviar;
    String h = "Juancho";
    String correo1 = "fredyjesus2013@gmail.com";
    String corre2 ="soymigue15@gmail.com";

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
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                String[] to = { correo1, corre2 };
                Send(to, "Pedido de \t"+ h,
                        "Usuario\t"+  h+ "\n"+ "\n"+
                    "DOTACION \n"+
                    "Camisa \t"+ "\n"+
                    "Pantalon \t"+ "\n"+
                    "Impermeable\t"+ "\n"+
                    "Chaleco \t"+ "\n"+
                    "Fajon \t"+ "\n"

                     +"\n"+"\n"+"============================================="+"\n"
                + "EPP \n"+
                  "Casco \t"+ "\n"+
                  "Guantes \t"+ "\n"+
                  "Gafas\t"+ "\n"+
                  "Protector Auditivo \t"+ "\n"+
                  "Tapabocas \t"+ "\n"+
                  "Equipo de Alturas \t"+ "\n"+
                  "Pantalon anti-corte \t"+ "\n"+
                  "Barbiquejo \t"+ "\n"+
                  "Termos \t"+ "\n"

                  +"\n"+"\n"+"============================================="+"\n"
                  + "HERRAMIENTAS \n"+

                    "Machete \t"+ "\n"+
                    "Tijeras \t"+ "\n"+
                    "Lima\t"+ "\n"+
                    "Pertiga \t"+ "\n"+
                    "Extintor \t"+ "\n"+
                    "Botiquin \t"+ "\n"+
                    "Conos \t"+ "\n"+
                    "Escaleras \t"+ "\n"+
                    "Alicate \t"+ "\n"+
                    "Martillo \t"+ "\n"+
                    "Multimetro \t"+ "\n"+
                     "Destornillador \t"+ "\n"+
                     "Cámara \t"+ "\n"+
                     "Vallas de Señalización \t"+ "\n"+
                     "Cinta de Señalización \t"+ "\n"+
                     "Juego de Llaves \t"+ "\n"+
                     "Cuchillo \t"+ "\n"+
                     "Cubo de Lona \t"+ "\n"+
                     "Pinza \t"+ "\n"



                );
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void Send(String[] to, String asunto, String mensaje){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");

        try{
            startActivity(emailIntent);
            finish();
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(View_final.this,"No Email",Toast.LENGTH_SHORT);
        }

    }
    }

