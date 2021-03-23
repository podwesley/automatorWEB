package br.com.project.pages;

import br.com.project.elements.ElementsVelocidadeInternet;

public class PageVelocidadeInternet extends ElementsVelocidadeInternet {

   private ElementsVelocidadeInternet elementsVelocidadeInternet = new ElementsVelocidadeInternet();


    public PageVelocidadeInternet informarTextoCampoPesquisa(String texto) {
        digitaValor(campoPesquisaGoogle, texto);
        return this;
    }

    public PageVelocidadeInternet clicarNoPrimeiroTexto() {
        clicar(texto);
        return this;
    }

    public PageVelocidadeInternet clicarExecutarTestesVelocidade() {
        clicar(botaoTestarVelocidade);
        return this;
    }
}
