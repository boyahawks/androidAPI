package com.example.interview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.interview.Adapter.AdapterFavorit;
import com.example.interview.Model.ModelFavorit;
import com.example.interview.Model.ModelLiga;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Favorit extends AppCompatActivity {

    List<ModelFavorit> modelFavoritArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        recyclerView = findViewById(R.id.listfavorit);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Favorit.this, LinearLayoutManager.VERTICAL, false));

        AndroidNetworking.get("https://github.com/boyahawks/API/blob/master/lihat_data.php")
                .build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ModelLiga>>(){}.getType();
                    modelFavoritArrayList = gson.fromJson(response.getJSONArray("leagues").toString(), type);
                    AdapterFavorit adapterFavorit = new AdapterFavorit(modelFavoritArrayList, Favorit.this);
                    recyclerView.setAdapter(adapterFavorit);
                    adapterFavorit.notifyDataSetChanged();
                } catch (Exception e){

                }
            }

            @Override
            public void onError(ANError anError) {

            }
        });

    }
}
