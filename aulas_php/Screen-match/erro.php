<?php

require 'autoload.php';

use ScreenMatch\Calculos\ConversorNotaEstrela;
use ScreenMatch\Modelo\Episodio;
use ScreenMatch\Modelo\Serie;
use ScreenMatch\Modelo\Genero;

$serie = new Serie('teste', 2024, Genero::Acao, 7,20,20);
$episodio = new Episodio($serie, 'piloto', 1);

$conversor = new ConversorNotaEstrela();
echo $conversor->converte($episodio);