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
    public void conectarBanco() {
        model.conectarBanco();
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
    public void atualizarLista() {
        model.atualizarLista();
    }

    @Override
    public void pesquisar(String termo) {
        model.pesquisar(termo);
    }

    @Override
    public void montarLista(Cursor c) {
        List<Musica> musicas = new ArrayList<>();
        while(c.moveToNext())
        {
            Musica musica = new Musica(
                    c.getString(c.getColumnIndex("cod")),
                    c.getString(c.getColumnIndex("titulo")),
                    c.getString(c.getColumnIndex("nome_musica")),
                    c.getString(c.getColumnIndex("letra")).substring(0,20)+"...");

            musicas.add(musica);
        }
        montarLista(musicas);
    }

    @Override
    public void buscarLetra(String cod) {
        model.buscarLetra(cod);
    }

    @Override
    public void setView(MVP.View view) {
        this.view = view;
        conectarBanco();
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
    public void montarLista(List<Musica> musicas) {
        view.montarLista(musicas);
    }


    @Override
    public void verLetra(Cursor c) {
        while(c.moveToNext())
        {
            String cod = c.getString(c.getColumnIndex("cod"));
            String banda  = c.getString(c.getColumnIndex("titulo"));
            String nome_musica = c.getString(c.getColumnIndex("nome_musica"));
            String letra = c.getString(c.getColumnIndex("letra"));

            view.verLetra(cod,banda,nome_musica,letra);
        }
    }

}
