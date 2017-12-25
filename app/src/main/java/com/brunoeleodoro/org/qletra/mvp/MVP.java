package com.brunoeleodoro.org.qletra.mvp;

import android.content.Context;
import android.database.Cursor;

import com.brunoeleodoro.org.qletra.MusicasAdapter;

/**
 * Created by bruno on 24/12/17.
 */

public interface MVP {
    interface Model
    {
        public void getLetras(String banda,String nome_musica);
        public void salvarLetra(String banda,String nome_musica,String letra);
        public void pesquisar(String termo);
        public void removerLetra(String cod);

    }
    interface Presenter
    {
        public void getLetras(String banda,String nome_musica);
        public void salvarLetra(String banda,String nome_musica,String letra);
        public void removerLetra(String cod);
        public void pesquisar(String termo);
        public void montarLista(Cursor c);

        public void setView(MVP.View view);
        public Context getContext();

        public void mostrarAviso(String msg);
        public void montarLista(MusicasAdapter adapter);
    }
    interface View
    {
        public void mostrarAviso(String msg);
        public void montarLista(MusicasAdapter adapter);
    }
}
