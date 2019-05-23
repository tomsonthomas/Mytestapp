package com.example.mytestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        final List<String> arrayList = new ArrayList<>();
/*ApiInterface apiInterface = RetrofitInstance.getInstance().create(ApiInterface.class);
apiInterface.getData("schedule").enqueue(new Callback<Model>() {
    @Override
    public void onResponse(Response<Model> response, Retrofit retrofit) {
        if(response.body().getInfo().size()>0){
            for(int i = 0;i<response.body().getInfo().size();i++) {
                arrayList.add(response.body().getInfo().get(i).getId()+" ,"+response.body().getInfo().get(i).getOpenTime());
           setData(arrayList);
            }
        }

    }

    @Override
    public void onFailure(Throwable t) {

    }
});*/
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =new StringRequest(Request.Method.POST,"http://beautyclub.nyesteventuretech.com/android/getTable.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    JSONArray json1 = json.getJSONArray("info");
                    ArrayList<Info> listdata = new ArrayList<Info>();
                    if (json1 != null) {
                        for (int i=0;i<json1.length();i++){
                            JSONObject jsonobject= (JSONObject) json1.get(i);
                            String id=jsonobject.optString("id");
                            String op=jsonobject.optString("open_time");
                            String cl=jsonobject.optString("close_time");
                            listdata.add(new Info(id,op,cl));

                        }
                    }
                    String status= json.getString("status");

                  //  JSONArray itemsArray= json.getJSONArray("info");

                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
                public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("table", "schedule");
                return params;
            }

        };
        queue.add(stringRequest);







    }

    private void setData(List<String> arrayList) {
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
