package com.brunoeleodoro.org.qletra;

/**
 * Created by bruno on 24/12/17.
 */

public class Musica {
    private String cod;
    private String titulo;
    private String nome_musica;
    private String letra;

    public Musica(String cod, String titulo, String nome_musica, String letra) {
        this.cod = cod;
        this.titulo = titulo;
        this.nome_musica = nome_musica;
        this.letra = letra;
    }

    public String getNome_musica() {
        return nome_musica;
    }

    public void setNome_musica(String nome_musica) {
        this.nome_musica = nome_musica;
    }

    public String getCod() {

        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
