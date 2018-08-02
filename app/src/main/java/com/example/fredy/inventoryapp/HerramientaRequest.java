package com.example.fredy.inventoryapp;



import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class HerramientaRequest extends StringRequest {
    private static final String HERRAMIENTA_REQUEST_URL = "https://inventoryapphola.000webhostapp.com/Herramienta.php";
    private Map<String, String> params;
    public HerramientaRequest(int llave, int martillo, Response.Listener<String> listener){
        super(Method.POST,HERRAMIENTA_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("llave",llave+"");
        params.put("martillo",martillo+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
