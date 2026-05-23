package com.example.scrrenmatch.ScreenMatch.principal;

import com.example.scrrenmatch.ScreenMatch.model.Episodio;
import com.example.scrrenmatch.ScreenMatch.model.EpisodioModel;
import com.example.scrrenmatch.ScreenMatch.model.SerieModel;
import com.example.scrrenmatch.ScreenMatch.model.TemporadaModel;
import com.example.scrrenmatch.ScreenMatch.service.ConsumoAPI;
import com.example.scrrenmatch.ScreenMatch.service.ConverteDados;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=3a7c26f5";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();

    public void exibeMenu(){

        System.out.print("Digite o nome da série para busca: ");
        var nomeSerie = teclado.nextLine();
        var json = consumoAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+").toLowerCase() + API_KEY);
        SerieModel serieModel = converteDados.obterDados(json, SerieModel.class);
        System.out.println("-----------------------------------");
        System.out.println("DADOS DA SÉRIE");
        System.out.println(serieModel);
        System.out.println();

        System.out.println("-----------------------------------");
        List<TemporadaModel> temporadas = new ArrayList<>();
        for (int i = 1; i <= serieModel.totalTemporadas(); i++ ){
            json = consumoAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+").toLowerCase() + "&season="+ i + API_KEY);
            TemporadaModel temporadaModel = converteDados.obterDados(json, TemporadaModel.class);
            temporadas.add(temporadaModel);
        }
        temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        System.out.println("---------------------------------------");
        System.out.println("TOP 5 EPISODIOS");

        List<EpisodioModel> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodioModel::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);


        System.out.println("---------------------------------");
        System.out.println("LISTA COM TODOS OS EPISODIOS");

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("-----------------------------------");
        System.out.println("FILTRANDO DATAS");

        System.out.println("A partir de que ano você deseja ver os episódios? ");
        var ano = teclado.nextInt();
        teclado.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println("Temporada: " + e.getTempoarada() +
                        "\nEpisódio: " + e.getTitulo() +
                        "\nData lançamento: " + e.getDataLancamento().format(formatador)));

    }
}
