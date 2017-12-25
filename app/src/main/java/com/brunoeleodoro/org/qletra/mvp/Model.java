package com.brunoeleodoro.org.qletra.mvp;

import android.database.Cursor;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.brunoeleodoro.org.qletra.Database;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by bruno on 24/12/17.
 */

public class Model implements MVP.Model {
    MVP.Presenter presenter;
    Database db;
    public Model(MVP.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void conectarBanco() {
        db = new Database(presenter.getContext());
    }

    @Override
    public void getLetras(final String banda, final String nome_musica) {
        RequestQueue queue = Volley.newRequestQueue(presenter.getContext());
        StringRequest request = new StringRequest(Request.Method.GET, "https://api.lyrics.ovh/v1/"+ URLEncoder.encode(banda) +"/"+URLEncoder.encode(nome_musica), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try
                {
                    JSONObject object = new JSONObject(s);
                    String letra = object.getString("lyrics");

                    salvarLetra(banda,nome_musica,letra);
                    presenter.mostrarAviso("Letra encontrada!\nlista atualizada.");
                }
                catch (Exception e)
                {
                    presenter.mostrarAviso("Letra não encontrada!");

                    Log.i("Script","erro getLetras="+e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("Script","volley error="+volleyError);
            }
        });
        queue.add(request);
    }

    @Override
    public void salvarLetra(String banda, String nome_musica, String letra) {
        db.sql("DELETE FROM musicas WHERE titulo=\""+banda+"\" AND nome_musica=\""+nome_musica+"\"");
        db.sql("INSERT INTO musicas VALUES(null,\""+banda+"\",\""+nome_musica+"\",\""+letra+"\");");
    }

    @Override
    public void pesquisar(String termo) {
        Cursor cursor = db.select("SELECT * FROM musicas WHERE " +
                "titulo LIKE \"%"+termo+"%\" OR " +
                "nome_musica LIKE \"%"+termo+"%\" OR " +
                "letra LIKE \""+termo+"\"");

        presenter.montarLista(cursor);
    }

    @Override
    public void removerLetra(String cod) {
        db.sql("DELETE FROM musicas WHERE cod="+cod);
        presenter.atualizarLista();
    }

    @Override
    public void atualizarLista() {
        Cursor c = db.select("SELECT * FROM musicas");
        presenter.montarLista(c);
    }

    @Override
    public void buscarLetra(String cod) {
        Cursor c = db.select("SELECT * FROM musicas WHERE cod="+cod);
        presenter.verLetra(c);
    }

}
