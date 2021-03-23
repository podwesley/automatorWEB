package br.com.project.testes;

import br.com.project.pages.PageVelocidadeInternet;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteVelocidadeInternet {

    private static PageVelocidadeInternet testesVelocidade;

    @BeforeClass
    public static void inicializarPagina() {
        testesVelocidade = new PageVelocidadeInternet();
    }

    @Test
    public void teste01EfetuarTesteVelocidadePeloGoogle() {

        testesVelocidade
                .informarTextoCampoPesquisa("testes de velocidade internet")
                .clicarNoPrimeiroTexto()
                .clicarExecutarTestesVelocidade();

    }

}
