<?php

namespace ScreenMatch\Modelo;

use ScreenMatch\Exception\NotaInvalidaException;

trait ComAvaliacao{
    private array $notas = [];

    /**
     * @throws \InvalidArgumentException Se a nota for negativa ou maior que 10
     */

    function avalia(float $nota): void {

        if($nota <0 || $nota >10){
            throw new NotaInvalidaException('Nota precisa ser entre 0 a 10');
        }

        $this->notas[] = $nota;
    }

    function media(): float{
        $somaNotas = array_sum($this->notas);
        $quantidadeNotas = count($this->notas);
        return $somaNotas / $quantidadeNotas;
    }
}