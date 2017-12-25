package com.brunoeleodoro.org.qletra.mvp;

import android.content.Context;
import android.database.Cursor;

import com.brunoeleodoro.org.qletra.Musica;
import com.brunoeleodoro.org.qletra.MusicasAdapter;

import java.util.List;

/**
 * Created by bruno on 24/12/17.
 */

public interface MVP {
    interface Model
    {
        public void conectarBanco();
        public void getLetras(String banda,String nome_musica);
        public void salvarLetra(String banda,String nome_musica,String letra);
        public void pesquisar(String termo);
        public void removerLetra(String cod);
        public void atualizarLista();
        public void buscarLetra(String cod);

    }
    interface Presenter
    {
        public void conectarBanco();
        public void getLetras(String banda,String nome_musica);
        public void salvarLetra(String banda,String nome_musica,String letra);
        public void removerLetra(String cod);
        public void atualizarLista();
        public void pesquisar(String termo);
        public void montarLista(Cursor c);
        public void buscarLetra(String cod);

        public void setView(MVP.View view);
        public Context getContext();

        public void mostrarAviso(String msg);
        public void montarLista(List<Musica> musicas);
        public void verLetra(Cursor c);
    }
    interface View
    {
        public void mostrarAviso(String msg);
        public void montarLista(List<Musica> musicas);
        public void verLetra(String cod,String banda,String nome_musica,String letra);
        public void buscarLetra(String cod);
        public void removerLetra(String cod);
    }
}
