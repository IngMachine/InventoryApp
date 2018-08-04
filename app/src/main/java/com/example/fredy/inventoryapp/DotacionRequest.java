package com.example.fredy.inventoryapp;

 import com.android.volley.Response;
 import com.android.volley.toolbox.StringRequest;

 import java.util.HashMap;
 import java.util.Map;

public class DotacionRequest extends StringRequest {
    private static final String HERRAMIENTA_REQUEST_URL = "https://inventoryapphola.000webhostapp.com/Dotacion.php";
    private Map<String, String> params;
    public DotacionRequest(int camisa, int pantalon,int zapato, Response.Listener<String> listener){
        super(Method.POST,HERRAMIENTA_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("camisa",camisa+"");
        params.put("pantalon",pantalon+"");
        params.put("zapato",zapato+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
