<?php

require 'autoload.php';
 
use ScreenMatch\Modelo\{Filme, Episodio, Serie, Genero};
use ScreenMatch\Calculos\{CalculadoraDeMaratona, ConversorNotaEstrela};

echo "Bem-vindo(a) ao ScreenMatch\n";

$filme = new Filme('Thor - Ragnarok', 2021, Genero::SuperHeroi, 175);

$filme-> avalia(10);
$filme-> avalia(10);
$filme-> avalia(5);
$filme-> avalia(5);

echo $filme->nome . "\n";
echo $filme->anoLancamento . "\n";
echo $filme->media() . "\n";
echo "-----\n";

$serie = new Serie('Lost', 2007, Genero::Drama, 10, 20, 30);
$episodio = new Episodio($serie, 'Piloto', 1);

echo $serie->nome . "\n";
echo $serie->anoLancamento . "\n";
$serie-> avalia(7);
echo $serie->media() . "\n";

$calculadora = new CalculadoraDeMaratona();
$calculadora->inclui($filme);
$calculadora->inclui($serie);
$duracao = $calculadora->duracao();

echo "para essa maratona, voce precisa de $duracao em minutos\n";

$conversor = new ConversorNotaEstrela();
echo $conversor->converte($serie) . "\n";
echo $conversor ->converte($filme);

