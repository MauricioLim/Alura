<?php

namespace ScreenMatch\Modelo;

class Serie extends Titulo{
    private array $notas; 

    public function __construct(
        string $nome,
        int $anoLancamento, 
        Genero $genero,
        public readonly int $temporadas,
        public readonly int $episodioTemporada,
        public readonly int $minutoEpisodio,
    ){     
        parent:: __construct($nome, $anoLancamento, $genero);
    }

    public function duracaoEmMinutos(): int{
        return $this -> temporadas * $this -> minutoEpisodio;
    }

}
