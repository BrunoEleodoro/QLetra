package com.brunoeleodoro.org.qletra;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VerLetra extends AppCompatActivity {
    String cod;
    String banda;
    String nome_musica;
    String letra;

    TextView txt_banda,txt_nome_musica,txt_letra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_letra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cod = getIntent().getStringExtra("cod");
        banda = getIntent().getStringExtra("banda");
        nome_musica = getIntent().getStringExtra("nome_musica");
        letra = getIntent().getStringExtra("letra");

        txt_banda = (TextView) findViewById(R.id.txt_banda);
        txt_nome_musica = (TextView) findViewById(R.id.txt_nome_musica);
        txt_letra = (TextView) findViewById(R.id.txt_letra);


        txt_banda.setText(banda);
        txt_nome_musica.setText(nome_musica);
        txt_letra.setText(letra);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
