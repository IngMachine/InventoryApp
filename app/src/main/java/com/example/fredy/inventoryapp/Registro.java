package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText etnombre,etusuario,etpassword,etedad,etemail;
    TextInputLayout impEmail,impNombre;
    boolean Cor=false,pas=false,Nor=false;
    Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        etnombre = findViewById(R.id.EditT_nombre);
        etusuario = findViewById(R.id.EditT_usuario);
        etpassword = findViewById(R.id.EditT_password);
        etedad = findViewById(R.id.EditT_edad);
        etemail = findViewById(R.id.EditT_email);
        impNombre = findViewById(R.id.impNombre);
        impEmail = findViewById(R.id.impEmail);

        btn_registrar = findViewById(R.id.Btn_registrar);

        btn_registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String name = etnombre.getText().toString();
        Pattern nombre = Pattern.compile(getString(R.string.expresion));
        if (!nombre.matcher(name).matches()){
            impNombre.setError("Nombre Invalido");
            Nor = false;
        }else {
            Nor = true;
            impNombre.setError(null);
        }
        final String username = etusuario.getText().toString();
        final String password = etpassword.getText().toString();
        final int age = Integer.parseInt(etedad.getText().toString());
        if (!Patterns.EMAIL_ADDRESS.matcher(etemail.getText().toString()).matches()){
            impEmail.setError("Correo Invalido");
            Cor=false;
        }else {
            Cor = true;
            impEmail.setError(null);
        }

        final String email = etemail.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean sucess = jsonResponse.getBoolean("succes");
                    if (sucess && Cor && Nor){
                        Intent intent = new Intent(Registro.this,MainActivity.class);
                        Registro.this.startActivity(intent);
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("error registro")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        if (Cor && Nor){
            RegisterRequest registerRequest = new RegisterRequest(name,username,age,password,email,respoListener);
            RequestQueue queue = Volley.newRequestQueue(Registro.this);
            queue.add(registerRequest);
        }


    }
}
