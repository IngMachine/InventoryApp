package com.example.fredy.inventoryapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView tv_registrar;
    EditText et_usuario,et_password;
    Button btn_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_registrar = findViewById(R.id.tv_registrar);
        et_usuario = findViewById(R.id.TV_usuario);
        et_password = findViewById(R.id.TV_password);
        btn_log = findViewById(R.id.Btn_iniciar);
        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistro = new Intent(MainActivity.this,Registro.class);
                MainActivity.this.startActivity(intentRegistro);
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = et_usuario.getText().toString();
                final String password = et_password.getText().toString();
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            System.out.println(jsonResponse);
                            boolean sucess = jsonResponse.getBoolean("success");
                            System.out.println(jsonResponse);
                            if (sucess){
                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                String email = jsonResponse.getString("email");

                                Intent intent = new Intent(MainActivity.this,Usuario.class);
                                intent.putExtra("name",name);
                                intent.putExtra("username",username);
                                intent.putExtra("age",age);
                                intent.putExtra("password",password);
                                intent.putExtra("email",email);
                                MainActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("error Login")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    queue.add(loginRequest);
            }
        });
    }
}
