package com.example.fredy.inventoryapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Epp extends AppCompatActivity {

    Spinner spiner, spiner1,spiner2,spiner3,spiner4,spiner5,spiner6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        spiner= findViewById(R.id.spinnerc);
        spiner1=findViewById(R.id.spinnerg);
        spiner2=findViewById(R.id.spinnera);
        spiner3=findViewById(R.id.spinnerb);
        spiner4=findViewById(R.id.spinnerar);
        spiner5=findViewById(R.id.spinnerma);
        spiner6=findViewById(R.id.spinnerta);


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


    }
}
