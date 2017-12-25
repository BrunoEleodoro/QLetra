package com.brunoeleodoro.org.qletra;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.brunoeleodoro.org.qletra.mvp.MVP;
import com.brunoeleodoro.org.qletra.mvp.Presenter;

import java.util.List;

public class SalvarLetra extends AppCompatActivity implements MVP.View{
    EditText txt_banda,txt_musica;
    MVP.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar_letra);

        presenter = new Presenter();
        presenter.setView(this);

        txt_banda = (EditText) findViewById(R.id.txt_banda);
        txt_musica = (EditText) findViewById(R.id.txt_musica);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getLetras(txt_banda.getText().toString(),txt_musica.getText().toString());
            }
        });
    }

    @Override
    public void mostrarAviso(String msg) {
        /*
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Aviso");
        dialog.setMessage(msg);
        dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();
        */
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void montarLista(List<Musica> musicas) {

    }


    @Override
    public void verLetra(String cod, String banda, String nome_musica, String letra) {

    }

    @Override
    public void buscarLetra(String cod) {

    }

    @Override
    public void removerLetra(String cod) {

    }
}
