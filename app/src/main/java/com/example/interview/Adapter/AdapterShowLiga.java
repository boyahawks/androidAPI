package com.example.interview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interview.Model.ModelLiga;
import com.example.interview.R;
import com.example.interview.SoalKedua;

import java.util.ArrayList;
import java.util.List;

public class AdapterShowLiga extends RecyclerView.Adapter<AdapterShowLiga.MyViewHolder>{

    List<ModelLiga> modelLigas = new ArrayList<>();
    Context context;

    public AdapterShowLiga() {
    }

    public AdapterShowLiga(List<ModelLiga> modelLigas, Context context) {
        this.modelLigas = modelLigas;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterShowLiga.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_ligalist, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterShowLiga.MyViewHolder myHolder, int i) {
        final String idLeague = modelLigas.get(i).getIdLeague();
        String strLeague = modelLigas.get(i).getStrLeague();
        String strSport = modelLigas.get(i).getStrSport();
        String strLeagueAlternate = modelLigas.get(i).getStrLeagueAlternate();

        myHolder.tv1.setText(idLeague);
        myHolder.tv2.setText(strLeague);
        myHolder.tv3.setText(strSport);
        myHolder.tv4.setText(strLeagueAlternate);

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SoalKedua.class);
                intent.putExtra("idLeague", idLeague);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2, tv3, tv4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.txt1);
            tv2 = itemView.findViewById(R.id.txt2);
            tv3 = itemView.findViewById(R.id.txt3);
            tv4 = itemView.findViewById(R.id.txt4);

        }
    }
}
