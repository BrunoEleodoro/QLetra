package com.brunoeleodoro.org.qletra;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bruno on 24/12/17.
 */

public class MusicasAdapter extends RecyclerView.Adapter<MusicasHolder> {

    @Override
    public MusicasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MusicasHolder(inflater.inflate(R.layout.linha,parent,false));
    }

    @Override
    public void onBindViewHolder(MusicasHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
