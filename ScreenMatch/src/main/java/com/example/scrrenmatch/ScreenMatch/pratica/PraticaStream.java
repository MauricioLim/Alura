package com.example.scrrenmatch.ScreenMatch.pratica;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PraticaStream {
    // 1 - Dada a lista de números inteiros abaixo, filtre apenas os números pares e imprima-os.

    public void listarPares(){
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(n -> n %2 == 0)
                .forEach(System.out::println);
    }

   //2 - Dada a lista de strings abaixo, converta todas para letras maiúsculas e imprima-as.
    public void converteMaiuscula(){
        List<String> palavras = Arrays.asList("java", "stream", "lambda");

        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // 3 - Dada a lista de números inteiros abaixo, filtre os números ímpares, multiplique cada um por 2 e colete os resultados em uma nova lista
    public void multiplaImpares(){
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> impares = numeros.stream()
                .filter(i -> !(i %2 == 0))
                .map(i -> i * 2)
                .collect(Collectors.toList());

        System.out.println(impares);
    }

    // 4 - Dada a lista de strings abaixo, remova as duplicatas (palavras que aparecem mais de uma vez) e imprima o resultado.
    public void removeDuplicata(){
        List<String> palavras = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        List<String> unicas = palavras.stream().distinct().collect(Collectors.toList());
        System.out.println(unicas);
    }

    //5 - Dada a lista de sublistas de números inteiros abaixo, extraia todos os números primos em uma única lista e os ordene em ordem crescente.

    public static boolean ehPrimo(int n){
        if (n < 2){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % 1 == 0){
                return false;
            }
        }

        return true;
    }

    public void extraiPrimo(){
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> primos = listaDeNumeros.stream()
                .flatMap(List::stream)
                .filter(PraticaStream::ehPrimo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(primos);
    }

    //6 - Dado um objeto Pessoa com os campos nome e idade, filtre as pessoas com mais de 18 anos, extraia os nomes e imprima-os em ordem alfabética. A classe Pessoa está definida abaixo.
    public void extraiNome(){
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );

        List<String> ordenado = pessoas.stream()
                .filter(p -> p.getIdade() >= 18)
                .map(Pessoa::getNome)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ordenado);
    }

    /* 7 - Você tem uma lista de objetos do tipo Produto, onde cada produto possui os atributos nome (String),
            preco (double) e categoria (String). Filtre todos os produtos da categoria "Eletrônicos" com preço menor que R$ 1000,
            ordene-os pelo preço em ordem crescente e colete o resultado numa nova lista.
     */
    public void extraiProduto(){
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        List<Produto> eletronicos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("eletrônicos") && p.getPreco() <= 1000)
                .sorted(Comparator.comparing(Produto::getPreco))
                .collect(Collectors.toList());

        System.out.println(eletronicos);
    }


}
