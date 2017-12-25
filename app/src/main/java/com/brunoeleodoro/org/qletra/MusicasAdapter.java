package com.brunoeleodoro.org.qletra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brunoeleodoro.org.qletra.mvp.MVP;
import com.brunoeleodoro.org.qletra.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 24/12/17.
 */

public class MusicasAdapter extends RecyclerView.Adapter<MusicasHolder>{

    MainActivity mainActivity;
    List<Musica> musicas = new ArrayList<>();
    Context context;
    public MusicasAdapter(MainActivity mainActivity,List<Musica> musicas, Context context) {
        this.musicas = musicas;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public MusicasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MusicasHolder(inflater.inflate(R.layout.linha,parent,false));
    }

    @Override
    public void onBindViewHolder(MusicasHolder holder, int position) {
        final Musica musica = musicas.get(position);
        holder.txt_titulo.setText(musica.getNome_musica());
        holder.txt_letra.setText(musica.getLetra());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.buscarLetra(musica.getCod());
            }
        });
        holder.txt_remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.removerLetra(musica.getCod());
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicas.size();
    }

}
