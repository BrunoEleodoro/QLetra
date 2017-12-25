package com.brunoeleodoro.org.qletra.mvp;

import android.content.Context;
import android.database.Cursor;

import com.brunoeleodoro.org.qletra.Musica;
import com.brunoeleodoro.org.qletra.MusicasAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 24/12/17.
 */

public class Presenter implements MVP.Presenter {
    private  MVP.View view;
    private  MVP.Model model;

    public Presenter()
    {
        model = new Model(this);
    }
    @Override
    public void getLetras(String banda, String nome_musica) {
        model.getLetras(banda,nome_musica);
    }

    @Override
    public void salvarLetra(String banda, String nome_musica, String letra) {
        model.salvarLetra(banda,nome_musica,letra);
    }

    @Override
    public void removerLetra(String cod) {
        model.removerLetra(cod);
    }

    @Override
    public void pesquisar(String termo) {
        model.pesquisar(termo);
    }

    @Override
    public void montarLista(Cursor c) {
        List<Musica> musicas = new ArrayList<>();

        int i = 0;
        while(i < c.getCount())
        {
            Musica musica = new Musica(
                    c.getString(c.getColumnIndex("cod")),
                    c.getString(c.getColumnIndex("titulo")),
                    c.getString(c.getColumnIndex("letra")));

            musicas.add(musica);
            i++;
        }

        MusicasAdapter adapter = new MusicasAdapter(musicas,getContext());
        montarLista(adapter);
    }

    @Override
    public void setView(MVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void mostrarAviso(String msg) {
        view.mostrarAviso(msg);
    }

    @Override
    public void montarLista(MusicasAdapter adapter) {
        view.montarLista(adapter);
    }
}
