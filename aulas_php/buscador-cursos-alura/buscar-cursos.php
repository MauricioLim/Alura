<?php

require 'vendor/autoload.php';



use Alura\BuscadorDeCursos\Buscador;
use GuzzleHttp\Client;
use Symfony\Component\DomCrawler\Crawler;

$client = new Client([
    'verify' => false, // Desative só para testes! Em produção, corrija o certificado.
    'base_uri' => 'https://www.alura.com.br/'
]);
$crawler = new Crawler();

$buscador  = new Buscador($client, $crawler);

$cursos = $buscador->buscar('/cursos-online-programacao/python');

foreach ($cursos as $curso){
    echo $curso . PHP_EOL;
}