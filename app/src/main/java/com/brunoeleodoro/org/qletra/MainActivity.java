package com.brunoeleodoro.org.qletra;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.brunoeleodoro.org.qletra.mvp.MVP;
import com.brunoeleodoro.org.qletra.mvp.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MVP.View{
    RecyclerView recyclerView;
    EditText txt_pesquisa;
    private MVP.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        txt_pesquisa = (EditText) findViewById(R.id.txt_pesquisa);

        presenter = new Presenter();
        presenter.setView(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SalvarLetra.class);
                startActivity(intent);
            }
        });

        txt_pesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.pesquisar(txt_pesquisa.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        presenter.atualizarLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void mostrarAviso(String msg) {
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
    }

    @Override
    public void montarLista(List<Musica> musicas) {
        MusicasAdapter adapter = new MusicasAdapter(this,musicas,this);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.atualizarLista();
    }

    @Override
    public void verLetra(String cod, String banda, String nome_musica, String letra) {
        Intent i = new Intent(this,VerLetra.class);
        i.putExtra("cod",cod);
        i.putExtra("banda",banda);
        i.putExtra("nome_musica",nome_musica);
        i.putExtra("letra",letra);
        startActivity(i);
    }

    @Override
    public void buscarLetra(String cod) {
        presenter.buscarLetra(cod);
    }

    @Override
    public void removerLetra(String cod) {
        presenter.removerLetra(cod);
    }
}
