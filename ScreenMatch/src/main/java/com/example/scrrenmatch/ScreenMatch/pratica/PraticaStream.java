package com.example.scrrenmatch.ScreenMatch.pratica;

import java.util.Arrays;
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
}
