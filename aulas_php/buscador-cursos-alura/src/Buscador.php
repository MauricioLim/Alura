<?php

namespace Alura\BuscadorDeCursos;

use GuzzleHttp\ClientInterface;
use GuzzleHttp\Exception\GuzzleException;
use Symfony\Component\DomCrawler\Crawler;


class Buscador
{

    private $httpClient;

    private $crawler;

    /**
     * @param ClientInterface $httpClient
     * @param Crawler $crawler
     */
    public function __construct(ClientInterface $httpClient, Crawler $crawler)
    {
        $this->httpClient = $httpClient;
        $this->crawler = $crawler;
    }

    /**
     * @param string $url
     * @return array
     * @throws GuzzleException
     */
    public function buscar(string $url): array{
        $resposta = $this ->httpClient -> request('GET', $url);

        $html = $resposta -> getBody();
        $this->crawler ->addHtmlContent($html);

        $elementosCursos =  $this->crawler -> filter('span.card-curso__nome');
        $cursos = [];
        foreach ($elementosCursos as $elemento){
            $cursos[] = $elemento-> textContent;
        }
        return $cursos;
    }

}