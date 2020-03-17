package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.interview.Adapter.AdapterShowLiga;
import com.example.interview.Model.ModelLiga;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SoalPertama extends AppCompatActivity {

    List<ModelLiga> modelLigaArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_pertama);

        recyclerView = findViewById(R.id.listLiga);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SoalPertama.this, LinearLayoutManager.VERTICAL, false));

        AndroidNetworking.get("https://www.thesportsdb.com/api/v1/json/1/all_leagues.php")
                .build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ModelLiga>>(){}.getType();
                    modelLigaArrayList = gson.fromJson(response.getJSONArray("leagues").toString(), type);
                    AdapterShowLiga adapterShowLiga = new AdapterShowLiga(modelLigaArrayList, SoalPertama.this);
                    recyclerView.setAdapter(adapterShowLiga);
                    adapterShowLiga.notifyDataSetChanged();
                } catch (Exception e){

                }
            }

            @Override
            public void onError(ANError anError) {

            }
        });

    }
}
