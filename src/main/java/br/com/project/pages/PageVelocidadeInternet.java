package br.com.project.pages;

import br.com.project.elements.ElementsVelocidadeInternet;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static br.com.project.Framework.core.DriverFactory.getDriver;

public class PageVelocidadeInternet extends ElementsVelocidadeInternet {

   private ElementsVelocidadeInternet elementsVelocidadeInternet = new ElementsVelocidadeInternet();

    @Step("Informar campo de pesquisa do google")
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

//    public PageVelocidadeInternet resultado() {
//        aguardarElementoSumir(By.xpath("//div[@jsname='k1yjKf']"));
//        return this;
//    }

    public void gerarResultado() {
        Allure.addAttachment("Screenshot" + LocalDate.now(),
                new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
