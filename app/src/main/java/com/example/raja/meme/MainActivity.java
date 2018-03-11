package com.example.raja.meme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
private static final String URL="http://rishabhnayak.ml/Test.json";
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass_list_recycler);
        final RecyclerView link = (RecyclerView) findViewById(R.id.pass_list_recycler);
        link.setLayoutManager(new LinearLayoutManager(this));
        StringRequest request=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                TextView textView=findViewById(R.id.test);
                Image image=new Gson().fromJson(response,Image.class);
                System.out.println(image.getMessage().getMeme().get(0).getLink());
                JSONObject object = null;
                try {
                    object = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject obj = null;
                try {
                    obj = object.getJSONObject("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray array=null;
                try {
                    array = obj.getJSONArray("meme");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println(array);
                Meme[] imagee = new Gson().fromJson(String.valueOf(array), Meme[].class);
                link.setAdapter(new PnrPassengerListAdapter(getApplicationContext(), imagee));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "somthing went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);
    }
}
