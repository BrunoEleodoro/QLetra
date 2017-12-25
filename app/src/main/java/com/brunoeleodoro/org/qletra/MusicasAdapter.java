package com.brunoeleodoro.org.qletra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 24/12/17.
 */

public class MusicasAdapter extends RecyclerView.Adapter<MusicasHolder> {
    List<Musica> musicas = new ArrayList<>();
    Context context;

    public MusicasAdapter(List<Musica> musicas, Context context) {
        this.musicas = musicas;
        this.context = context;
    }

    @Override
    public MusicasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MusicasHolder(inflater.inflate(R.layout.linha,parent,false));
    }

    @Override
    public void onBindViewHolder(MusicasHolder holder, int position) {
        Musica musica = musicas.get(position);

        holder.txt_titulo.setText(musica.getTitulo());
        holder.txt_letra.setText(musica.getLetra());
    }

    @Override
    public int getItemCount() {
        return musicas.size();
    }
}
