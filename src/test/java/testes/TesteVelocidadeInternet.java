package testes;

import br.com.project.pages.PageVelocidadeInternet;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteVelocidadeInternet {

    //Importante.
    //https://stackoverflow.com/questions/48709263/how-to-customize-allure-report-title-and-logo

    private static PageVelocidadeInternet testesVelocidade;

    @BeforeClass
    public static void inicializarPagina() {
        testesVelocidade = new PageVelocidadeInternet();

    }

    @Test
    @DisplayName("Disparar teste de velocidade")
    @Description("Este teste tem a finalidade de efetuar um teste de velocidade pelo google")
    public void teste01EfetuarTesteVelocidadePeloGoogle() {

        testesVelocidade
                .informarTextoCampoPesquisa("testes de velocidade internet")
                .clicarNoPrimeiroTexto()
                .clicarExecutarTestesVelocidade()
                .resultado()
                .printAllure();

    }
}
