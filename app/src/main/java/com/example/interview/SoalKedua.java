package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.interview.Adapter.AdapterLigaDipilih;
import com.example.interview.Adapter.AdapterShowLiga;
import com.example.interview.Model.ModelLiga;
import com.example.interview.Model.ModelLigaDipilih;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SoalKedua extends AppCompatActivity {

    String idLeague;
    List<ModelLigaDipilih> modelLigaDipilihArray = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_kedua);

        Intent intent = getIntent();
        idLeague = intent.getStringExtra("idLeague");

        recyclerView = findViewById(R.id.rvView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SoalKedua.this, LinearLayoutManager.VERTICAL, false));

        showtheData();

    }

    String idTeamS, strTeamS, strSportS, strTeamShortS, intFormedYearS, strLeagueS, strStadiumDescriptionS;

    private void showtheData() {
        AndroidNetworking.get("https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=" + idLeague)
                .build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ModelLigaDipilih>>(){}.getType();
                    modelLigaDipilihArray = gson.fromJson(response.getJSONArray("teams").toString(), type);
                    AdapterLigaDipilih adapterLigaDipilih = new AdapterLigaDipilih(modelLigaDipilihArray, SoalKedua.this);
                    recyclerView.setAdapter(adapterLigaDipilih);
                    adapterLigaDipilih.notifyDataSetChanged();
                } catch (Exception e){
                    Log.e("SoalKedua", "" + e.getMessage());
                }
            }

            @Override
            public void onError(ANError anError) {

            }
        });
    }
}
