package com.example.interview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interview.Model.ModelLiga;
import com.example.interview.Model.ModelLigaDipilih;
import com.example.interview.R;
import com.example.interview.SoalKedua;
import com.example.interview.SoalKetiga;

import java.util.ArrayList;
import java.util.List;

public class AdapterLigaDipilih extends RecyclerView.Adapter<AdapterLigaDipilih.MyViewHolder>{

    List<ModelLigaDipilih> modelLigas = new ArrayList<>();
    Context context;

    public AdapterLigaDipilih() {
    }

    public AdapterLigaDipilih(List<ModelLigaDipilih> modelLigas, Context context) {
        this.modelLigas = modelLigas;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterLigaDipilih.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_ligadipilih, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLigaDipilih.MyViewHolder myHolder, int i) {
        final String idTeam = modelLigas.get(i).getIdTeam();
        String strTeam = modelLigas.get(i).getStrTeam();
        String strTeamShort = modelLigas.get(i).getStrTeamShort();
        String intFormedYear = modelLigas.get(i).getIntFormedYear();
        String strSport = modelLigas.get(i).getStrSport();
        String strLeague = modelLigas.get(i).getStrLeague();
        String strStadiumDescription = modelLigas.get(i).getStrStadiumDescription();

        myHolder.tv1.setText(idTeam);
        myHolder.tv2.setText(strTeam);
        myHolder.tv3.setText(strTeamShort);
        myHolder.tv4.setText(intFormedYear);
        myHolder.tv5.setText(strSport);
        myHolder.tv6.setText(strLeague);
        myHolder.tv7.setText(strStadiumDescription);

        myHolder.informasiDetailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SoalKetiga.class);
                intent.putExtra("idTeamSSS", idTeam);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;
        Button informasiDetailBTN;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.idteam);
            tv2 = itemView.findViewById(R.id.strteam);
            tv3 = itemView.findViewById(R.id.strteamshort);
            tv4 = itemView.findViewById(R.id.intformedyear);
            tv5 = itemView.findViewById(R.id.strsport);
            tv6 = itemView.findViewById(R.id.strleague);
            tv7 = itemView.findViewById(R.id.strstadiumdescription);
            informasiDetailBTN = itemView.findViewById(R.id.informasiDetailBTN);

        }
    }
}
