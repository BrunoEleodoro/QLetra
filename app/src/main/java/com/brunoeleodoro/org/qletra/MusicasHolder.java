package com.brunoeleodoro.org.qletra;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by bruno on 24/12/17.
 */

public class MusicasHolder extends RecyclerView.ViewHolder {

    private TextView txt_titulo;
    private TextView txt_letra;
    private ImageButton txt_remover;

    public MusicasHolder(View view) {
        super(view);
        txt_titulo = (TextView) view.findViewById(R.id.txt_titulo);
        txt_letra = (TextView) view.findViewById(R.id.txt_letra);
        txt_remover = (ImageButton) view.findViewById(R.id.txt_remover);


    }
}
