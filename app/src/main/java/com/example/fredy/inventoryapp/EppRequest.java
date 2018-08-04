package com.example.fredy.inventoryapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class EppRequest extends StringRequest {
    private static final String HERRAMIENTA_REQUEST_URL = "https://inventoryapphola.000webhostapp.com/Epp.php";
    private Map<String, String> params;
    public EppRequest(int casco, int gafas, Response.Listener<String> listener){
        super(Method.POST,HERRAMIENTA_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("casco",casco+"");
        params.put("gafas",gafas+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
