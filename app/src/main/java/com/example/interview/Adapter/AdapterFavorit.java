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

import com.example.interview.Model.ModelFavorit;
import com.example.interview.Model.ModelLigaDipilih;
import com.example.interview.R;
import com.example.interview.SoalKetiga;

import java.util.ArrayList;
import java.util.List;

public class AdapterFavorit extends RecyclerView.Adapter<AdapterFavorit.MyViewHolder>{

    List<ModelFavorit> modelFavorits = new ArrayList<>();
    Context context;

    public AdapterFavorit() {
    }

    public AdapterFavorit(List<ModelFavorit> modelFavorits, Context context) {
        this.modelFavorits = modelFavorits;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterFavorit.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_listfavorit, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavorit.MyViewHolder myHolder, int i) {
        final String idTeam = modelFavorits.get(i).getIdTeam();
        String strTeam = modelFavorits.get(i).getStrTeam();
        String strTeamShort = modelFavorits.get(i).getStrTeamShort();
        String strStadium = modelFavorits.get(i).getStrStadium();


        myHolder.tv1.setText(idTeam);
        myHolder.tv2.setText(strTeam);
        myHolder.tv3.setText(strTeamShort);
        myHolder.tv4.setText(strStadium);


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2, tv3, tv4;
        Button informasiDetailBTN;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.txt1);
            tv2 = itemView.findViewById(R.id.txt2);
            tv3 = itemView.findViewById(R.id.txt3);
            tv4 = itemView.findViewById(R.id.txt4);



        }
    }
}
