package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.interview.Model.ModelLigaDipilih;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SoalKetiga extends AppCompatActivity {

    String idTeamSSS;
    TextView strTeam, strTeamShort,idTeam,strSport,intFormedYear, strStadiumDescription;
    Button  button, button1;

    List<ModelLigaDipilih> modelLigaDipilihArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_ketiga);

        strTeam = findViewById(R.id.strteam);
        strTeamShort = findViewById(R.id.strteamshort);
        idTeam = findViewById(R.id.idteam);
        strSport = findViewById(R.id.strsport);
        intFormedYear = findViewById(R.id.intformedyear);
        strStadiumDescription = findViewById(R.id.strstadiumdescription);
        button = findViewById(R.id.backhome);
        button1 = findViewById(R.id.btnfavorit);

        Intent intent = getIntent();
        idTeamSSS = intent.getStringExtra("idTeamSSS");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoalKetiga.this, SoalPertama.class));
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoalKetiga.this, Favorit.class));
                finish();
            }
        });



        showAllDataWawwwww();

    }

    String idTeamAN, strTeamAN, strTeamShortAN, strSportAN, intFormedYearAN, strStadiumDescriptionAN;

    private void showAllDataWawwwww() {
        AndroidNetworking.get("https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=" + idTeamSSS)
                .build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ModelLigaDipilih>>(){}.getType();
                    modelLigaDipilihArray = gson.fromJson(response.getJSONArray("teams").toString(), type);

                    for (int i = 0; i <= modelLigaDipilihArray.size(); i++){

                        if (modelLigaDipilihArray.get(i).getIdTeam() == null){
                            idTeam.setText("Data Tidak Ada");
                        } else {
                            idTeam.setText(modelLigaDipilihArray.get(i).getIdTeam());
                        }

                        if (modelLigaDipilihArray.get(i).getStrTeam() == null){
                            strTeam.setText("Data Tidak Ada");
                        } else {
                            strTeam.setText(modelLigaDipilihArray.get(i).getStrTeam());
                        }

                        if (modelLigaDipilihArray.get(i).getStrTeamShort() == null){
                            strTeamShort.setText("Data Tidak Ada");
                        } else {
                            strTeamShort.setText(modelLigaDipilihArray.get(i).getStrTeamShort());
                        }

                        if (modelLigaDipilihArray.get(i).getStrSport() == null){
                            strSport.setText("Data Tidak Ada");
                        } else {
                            strSport.setText(modelLigaDipilihArray.get(i).getStrSport());
                        }

                        if (modelLigaDipilihArray.get(i).getIntFormedYear() == null){
                            intFormedYear.setText("Data Tidak Ada");
                        } else {
                            intFormedYear.setText(modelLigaDipilihArray.get(i).getIntFormedYear());
                        }

                        if (modelLigaDipilihArray.get(i).getStrStadiumDescription() == null){
                            strStadiumDescription.setText("Data Tidak Ada");
                        } else {
                            strStadiumDescription.setText(modelLigaDipilihArray.get(i).getStrStadiumDescription());
                        }
                    }
//                    if (!response.getJSONObject("teams").isNull("idTeam")){
//                        idTeamAN = response.getJSONObject("teams").getString("idTeam");
//                        idTeam.setText(idTeamAN);
//                    } else {
//                        idTeam.setText("Data Tidak Ada");
//                    }
//
//                    if (!response.getJSONObject("teams").isNull("strTeam")){
//                        strTeamAN = response.getJSONObject("teams").getString("strTeam");
//                        strTeam.setText(strTeamAN);
//                    } else {
//                        strTeam.setText("Data Tidak Ada");
//                    }
//
//                    if (!response.getJSONObject("teams").isNull("strTeamShort")){
//                        strTeamShortAN = response.getJSONObject("teams").getString("strTeamShort");
//                        strTeamShort.setText(strTeamShortAN);
//                    } else {
//                        strTeamShort.setText("Data Tidak Ada");
//                    }
//
//                    if (!response.getJSONObject("teams").isNull("strSport")){
//                        strSportAN = response.getJSONObject("teams").getString("strSport");
//                        strSport.setText(strSportAN);
//                    } else {
//                        strSport.setText("Data Tidak Ada");
//                    }
//
//                    if (!response.getJSONObject("teams").isNull("intFormedYear")){
//                        intFormedYearAN = response.getJSONObject("teams").getString("intFormedYear");
//                        intFormedYear.setText(intFormedYearAN);
//                    } else {
//                        intFormedYear.setText("Data Tidak Ada");
//                    }
//
//                    if (!response.getJSONObject("teams").isNull("strStadiumDescription")){
//                        strStadiumDescriptionAN = response.getJSONObject("teams").getString("strStadiumDescription");
//                        strStadiumDescription.setText(strStadiumDescriptionAN);
//                    } else {
//                        strStadiumDescription.setText("Data Tidak Ada");
//                    }
                } catch (Exception e){

                }
            }

            @Override
            public void onError(ANError anError) {

            }
        });
    }
}
