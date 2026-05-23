package com.example.scrrenmatch.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {

    private Integer tempoarada;
    private String titulo;
    private Integer numero;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numero, EpisodioModel d) {
        this.tempoarada = numero;
        this.titulo = d.titulo();
        this.numero = d.numero();
        try {
            this.avaliacao = Double.valueOf(d.avaliacao());
        } catch (NumberFormatException ex){
            this.avaliacao = 0.0;
        }

        try {
            this.dataLancamento =  LocalDate.parse(d.dataLancamento());
        } catch (DateTimeParseException ex){
            this.dataLancamento = null;
        }

    }


    public Integer getTempoarada() {
        return tempoarada;
    }

    public void setTempoarada(Integer tempoarada) {
        this.tempoarada = tempoarada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "tempoarada=" + tempoarada +
                ", titulo= " + titulo +
                ", numero=" + numero +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento;
    }
}
