<?php

require __DIR__ ."/src/Modelo/Filme.php";
require __DIR__ . "/src/funcoes.php";

echo "Bem vindo ao screen match!\n" .PHP_EOL;

$nomeFIlme = "Top Gun - Maverick";
$nomeFIlme = "Thor: Ragnarok";
$nomeFIlme = "Se beber não case";
$anoLancamento = 2022;

$quantidadeNotas = $argc - 1;
$somaDeNotas = 0;
$notas = [];

for ($i = 1; $i < $argc; $i++) {
    $notas[] = (float) $argv[$i];
}


$notaFilme = array_sum($notas) / $quantidadeNotas;
$planoPrime = True;

echo "Nome do filme: $nomeFilme \n";
echo "Ano do lançamento: $anoLancamento\n";

exibeMensagemLancamento($anoLancamento);
$incluido = incluidoNoPlano($planoPrime, $anoLancamento);

echo "Nota do filme $notaFilme\n";

$genero = match ($nomeFIlme) {
    "Top Gun - Maverick" => "ação",
    "Thor: Ragnarok" => "Super heroi",
    "Se beber não case" => "comedia",
    default => "genero desconhecido",
};

echo "O genero do filme é: $genero \n";

$filme = criaFilme("Thor: Ragnarok", 2021, 7.7, "super-herói");

echo $filme->anoLancamento;

var_dump($notas);
sort($notas);
var_dump($notas);
$menorNota = min($notas);
var_dump($menorNota);

var_dump($filme->nome);
$posicaoDoisPontos = strpos($filme->nome, ':');
var_dump($posicaoDoisPontos);

var_dump(substr($filme->nome, 0, $posicaoDoisPontos));

$filmeComoStringJson = json_encode($filme);
file_put_contents(__DIR__ . '/filme.json', $filmeComoStringJson);
